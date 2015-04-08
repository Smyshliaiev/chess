package com.example.pieces;

import com.example.common.Position;

import java.util.List;

/**
 * Created by Toxa on 06.04.2015.
 */
public class King extends Piece {

    public King(List<Integer> pieceIdentifiers) {
        mPieceId = pieceIdentifiers.size();
        pieceIdentifiers.add(mPieceId);

        mPiecesType = PiecesType.KING;
        mPosition = new Position(INIT_COORDINATE, INIT_COORDINATE);
    }

    @Override
    protected void fillMatrixWithPieceMovements() {

        if( checkGoodBounds(getPosition(), 0, 0)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY(), HIT_VALUE);
        if( checkGoodBounds(getPosition(), 1, 0)) mRealMatrix.setEntry(getPosition().getX()+1, getPosition().getY(), HIT_VALUE);
        if( checkGoodBounds(getPosition(), 1, 1)) mRealMatrix.setEntry(getPosition().getX()+1, getPosition().getY()+1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), 0, 1)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY()+1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), -1, 1)) mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY()+1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), -1, 0)) mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY(), HIT_VALUE);
        if( checkGoodBounds(getPosition(), -1, -1)) mRealMatrix.setEntry(getPosition().getX()-1, getPosition().getY()-1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), 0, -1)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY()-1, HIT_VALUE);
        if( checkGoodBounds(getPosition(), 1, -1)) mRealMatrix.setEntry(getPosition().getX()+1, getPosition().getY()-1, HIT_VALUE);
    }

}
