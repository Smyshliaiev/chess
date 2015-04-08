package com.example.pieces;

import com.example.common.Position;

import java.util.List;

/**
 * Created by Toxa on 07.04.2015.
 */
public class Knight extends Piece {

    public Knight(List<Integer> pieceIdentifiers) {
        mPieceId = pieceIdentifiers.size();
        pieceIdentifiers.add(mPieceId);

        mPiecesType = PiecesType.KNIGHT;
        mPosition = new Position(INIT_COORDINATE, INIT_COORDINATE);
    }


    @Override
    protected void fillMatrixWithPieceMovements() {
        if (checkGoodBounds(getPosition(), 0, 0))
            mRealMatrix.setEntry(getPosition().getX(), getPosition().getY(), HIT_VALUE);
        if (checkGoodBounds(getPosition(), 2, 1))
            mRealMatrix.setEntry(getPosition().getX() + 2, getPosition().getY() + 1, HIT_VALUE);
        if (checkGoodBounds(getPosition(), 1, 2))
            mRealMatrix.setEntry(getPosition().getX() + 1, getPosition().getY() + 2, HIT_VALUE);
        if (checkGoodBounds(getPosition(), -1, 2))
            mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY() + 2, HIT_VALUE);
        if (checkGoodBounds(getPosition(), -2, 1))
            mRealMatrix.setEntry(getPosition().getX() - 2, getPosition().getY() + 1, HIT_VALUE);
        if (checkGoodBounds(getPosition(), -2, -1))
            mRealMatrix.setEntry(getPosition().getX() - 2, getPosition().getY() - 1, HIT_VALUE);
        if (checkGoodBounds(getPosition(), -1, -2))
            mRealMatrix.setEntry(getPosition().getX() - 1, getPosition().getY() - 2, HIT_VALUE);
        if (checkGoodBounds(getPosition(), 1, -2))
            mRealMatrix.setEntry(getPosition().getX() + 1, getPosition().getY() - 2, HIT_VALUE);
        if (checkGoodBounds(getPosition(), 2, -1))
            mRealMatrix.setEntry(getPosition().getX() + 2, getPosition().getY() - 1, HIT_VALUE);

    }

}