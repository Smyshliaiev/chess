package com.example;

import com.example.common.ChessBoard;
import com.example.common.ParamReader;
import com.example.common.Position;
import com.example.common.UniquePosition;
import com.example.pieces.*;
import org.apache.commons.math3.linear.DefaultRealMatrixChangingVisitor;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class MainWorker {

    public static int BOARD_HEIGHT = 3;
    public static int BOARD_WIDTH = 3;

    private ParamReader mParamReader;
    private List<IPiece> mPiecesInput = new ArrayList<IPiece>();
    private HashSet mResultHashSet = new HashSet();

    public MainWorker(ParamReader paramReader) {
        mParamReader = paramReader;
        createPiecesAndBoardFromParams();
    }

    public void findUniqueConfigurations() {
        findUnique(mPiecesInput);
    }


    private void createPiecesAndBoardFromParams(){
        BOARD_HEIGHT = mParamReader.getBoardRows();
        BOARD_WIDTH = mParamReader.getBoardCols();

        List<Integer> ids = new ArrayList<Integer>();
        for(int i = 0; i < mParamReader.getKingAmt();i ++)  { IPiece king = new King(ids); mPiecesInput.add(king); }
        for(int i = 0; i < mParamReader.getQueenAmt();i ++) { IPiece queen = new Queen(ids); mPiecesInput.add(queen); }
        for(int i = 0; i < mParamReader.getBishopAmt();i ++){ IPiece bishop = new Bishop(ids); mPiecesInput.add(bishop); }
        for(int i = 0; i < mParamReader.getKnightAmt();i ++){ IPiece knight = new Knight(ids); mPiecesInput.add(knight); }
        for(int i = 0; i < mParamReader.getRookAmt();i ++)  { IPiece rook = new Rook(ids); mPiecesInput.add(rook); }

    }

    private void findUnique(List<IPiece> variantOfPermutedPieces) {
        findUniqueReq(variantOfPermutedPieces, variantOfPermutedPieces.size());
        System.out.println("");
        System.out.println("Unique configurations amount of pieces is: " + mResultHashSet.size());
    }

    private void findUniqueReq(List<IPiece> variantOfPermutedPieces, int reqDeep){
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.getChessBoardMatrix().walkInRowOrder(new SetVisitor(variantOfPermutedPieces, reqDeep, chessBoard.getChessBoardMatrix().copy()));
    }

    // class that visits every position in the matrix
    private class SetVisitor extends DefaultRealMatrixChangingVisitor {
        private int mReqDeep;
        private List<IPiece> mVariantOfPermutedPieces;
        private RealMatrix mRealMatrixInOriginal;


        private SetVisitor(List<IPiece> variantOfPermutedPieces, int reqDeep, RealMatrix realMatrix) {
            mReqDeep = reqDeep;
            mVariantOfPermutedPieces = variantOfPermutedPieces;
            mRealMatrixInOriginal = realMatrix;
        }

        @Override
        public double visit(int i, int j, double value) {
            //if visited cell is empty
            if(mRealMatrixInOriginal.getEntry(i,j) == Piece.FREE_VALUE){
                //create local copy of the matrix that we got on this level of recursion
                RealMatrix copyOfInMatrix = mRealMatrixInOriginal.copy();

                //get piece for current level of recursion
                IPiece piece =  mVariantOfPermutedPieces.get(mReqDeep);
                //set 1 to all hit positions that current piece can do
                piece.setPosition(new Position(i,j));
                copyOfInMatrix = copyOfInMatrix.add(piece.getPieceMovementMatrix());

                // process the deepest level of recursion (means that all pieces are on the board)
                if(mReqDeep == 0) {
                    HashSet listOfUniquePos = iterateAllFigurePositions(mVariantOfPermutedPieces, mReqDeep, copyOfInMatrix);
                    if (listOfUniquePos.size()==mVariantOfPermutedPieces.size()) {
                        mResultHashSet.add(listOfUniquePos);
                    }
                }

                mVariantOfPermutedPieces.get(mReqDeep).clearMatrix();

                //if we have a deeper level go there (means set one more piece on the board)
                if(mReqDeep>0) {
                    copyOfInMatrix.walkInRowOrder(new SetVisitor(mVariantOfPermutedPieces, mReqDeep, copyOfInMatrix));
                }

            }
            return mRealMatrixInOriginal.getEntry(i,j);
        }

        private HashSet iterateAllFigurePositions(List<IPiece> variantOfPermutedPieces, int deep, RealMatrix currentMatrix) {
            HashSet localHashSet = new HashSet();
            for(IPiece piece: variantOfPermutedPieces){
                if(currentMatrix.getEntry(piece.getPosition().getX(), piece.getPosition().getY()) > Piece.HIT_VALUE){
                    localHashSet.clear();
                }else if(currentMatrix.getEntry(piece.getPosition().getX(), piece.getPosition().getY()) == Piece.HIT_VALUE) {
                    localHashSet.add(new UniquePosition(piece.getType(), piece.getPosition()));
                }
            }
            return localHashSet;
        }

        @Override
        public void start(int rows, int columns, int startRow, int endRow, int startColumn, int endColumn) {
            --mReqDeep;
            super.start(rows, columns, startRow, endRow, startColumn, endColumn);
        }

        @Override
        public double end() {
            mVariantOfPermutedPieces.get(mReqDeep).setPosition(new Position(Piece.INIT_COORDINATE, Piece.INIT_COORDINATE));
            mVariantOfPermutedPieces.get(mReqDeep).clearMatrix();
            return super.end();
        }
    }

}
