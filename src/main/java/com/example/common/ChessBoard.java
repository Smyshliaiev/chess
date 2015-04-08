package com.example.common;

import com.example.MainWorker;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Toxa on 06.04.2015.
 */

/**
 * Initial clear chessboard
 */
public class ChessBoard {

    private RealMatrix mRealMatrix;
    private static int mHeight = MainWorker.BOARD_HEIGHT;
    private static int mWidth = MainWorker.BOARD_WIDTH;

    public ChessBoard() {
        mRealMatrix = MatrixUtils.createRealMatrix(mWidth, mHeight);
    }

    public static int getWidth() {
        return mWidth;
    }

    public static int getHeight() {
        return mHeight;
    }

    public RealMatrix getChessBoardMatrix() {
        return mRealMatrix;
    }

}
