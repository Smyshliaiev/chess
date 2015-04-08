package com.example.pieces;

import com.example.common.ChessBoard;
import com.example.common.Position;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Toxa on 06.04.2015.
 */
public abstract class Piece implements IPiece {

    public static final double HIT_VALUE = 1;
    public static final double FREE_VALUE = 0;
    public static final int INIT_COORDINATE = -100;

    protected int mPieceId;
    protected PiecesType mPiecesType;
    protected Position mPosition;
    protected RealMatrix mRealMatrix;

    protected Piece() {
        mRealMatrix = MatrixUtils.createRealMatrix(ChessBoard.getWidth(), ChessBoard.getHeight());
    }

    protected abstract void fillMatrixWithPieceMovements();

    public void clearMatrix(){
        mRealMatrix = MatrixUtils.createRealMatrix(ChessBoard.getWidth(), ChessBoard.getHeight());
    }

    protected boolean checkGoodBounds(Position position, int diffX, int diffY){

        if((position.getX() + diffX)  < 0 || (position.getY() + diffY) < 0 ){
            return false;
        }
        if((position.getX() +diffX)>= ChessBoard.getWidth() || (position.getY() + diffY) >= ChessBoard.getHeight() ){
            return false;
        }

        return true;
    }

    @Override
    public PiecesType getType() {
        return mPiecesType;
    }

    @Override
    public Position getPosition() {
        return mPosition;
    }

    @Override
    public void setPosition(Position position) {
        mPosition = position;
        fillMatrixWithPieceMovements();
    }

    @Override
    public int getIdentifier() {
        return mPieceId;
    }

    @Override
    public RealMatrix getPieceMovementMatrix() {
        return mRealMatrix;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id: ").
                append(getIdentifier()).
                append(", type: ").
                append(getType()).
                append(", position: ").
                append(getPosition()).
                append("; ");

        return builder.toString();
    }
}
