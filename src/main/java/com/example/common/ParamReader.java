package com.example.common;

import com.example.pieces.PiecesType;

import java.util.Scanner;

/**
 * Created by Toxa on 08.04.2015.
 */

/**
 * Read input params class
 */
public class ParamReader {
    private int mBoardRows;
    private int mBoardCols;
    private int mQueenAmt;
    private int mRookAmt;
    private int mBishopAmt;
    private int mKnightAmt;
    private int mKingAmt;

    Scanner mScanner = new Scanner(System.in);

    public void readParams(String[] args){
        System.out.print("Enter ChessBoard Rows(f.e. 4): ");
        mBoardRows = mScanner.nextInt();
        System.out.print("Enter ChessBoard Columns(f.e. 4): ");
        mBoardCols = mScanner.nextInt();
        for(PiecesType piecesType: PiecesType.values()){
            System.out.println(piecesType.name() + " type is (" + piecesType.ordinal() + ")");
        }
        System.out.print("Enter number of Rook pieces (f.e. 2): ");
        mRookAmt = mScanner.nextInt();
        System.out.print("Enter number of Knight pieces (f.e. 4): ");
        mKnightAmt = mScanner.nextInt();
        System.out.print("Enter number of King pieces (f.e. 0): ");
        mKingAmt = mScanner.nextInt();
        System.out.print("Enter number of Queen pieces (f.e. 0): ");
        mQueenAmt = mScanner.nextInt();
        System.out.print("Enter number of Bishop pieces (f.e. 0): ");
        mBishopAmt = mScanner.nextInt();
        System.out.println("");
        System.out.println("Params has been taken:");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ParamReader{" +
                "mKingAmt=" + mKingAmt +
                ", mKnightAmt=" + mKnightAmt +
                ", mBishopAmt=" + mBishopAmt +
                ", mRookAmt=" + mRookAmt +
                ", mQueenAmt=" + mQueenAmt +
                ", mBoardCols=" + mBoardCols +
                ", mBoardRows=" + mBoardRows +
                '}';
    }

    public int getBoardRows() {
        return mBoardRows;
    }

    public int getBoardCols() {
        return mBoardCols;
    }

    public int getQueenAmt() {
        return mQueenAmt;
    }

    public int getRookAmt() {
        return mRookAmt;
    }

    public int getBishopAmt() {
        return mBishopAmt;
    }

    public int getKnightAmt() {
        return mKnightAmt;
    }

    public int getKingAmt() {
        return mKingAmt;
    }
}
