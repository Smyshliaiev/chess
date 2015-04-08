package com.example.pieces;

import com.example.common.Position;

import java.util.List;

/**
 * Created by Toxa on 07.04.2015.
 */
public class Bishop  extends Piece{

    public Bishop(List<Integer> pieceIdentifiers) {
        mPieceId = pieceIdentifiers.size();
        pieceIdentifiers.add(mPieceId);

        mPiecesType = PiecesType.BISHOP;
        mPosition = new Position(INIT_COORDINATE, INIT_COORDINATE);
    }


    @Override
    protected void fillMatrixWithPieceMovements() {
        if( checkGoodBounds(getPosition(), 0, 0)) mRealMatrix.setEntry(getPosition().getX(), getPosition().getY(), HIT_VALUE);

        int i=0;
        while(checkGoodBounds(getPosition(), i, i)){
            mRealMatrix.setEntry(getPosition().getX()+i, getPosition().getY()+i, HIT_VALUE);
            i++;
        }
        i=0;
        while(checkGoodBounds(getPosition(), -i, -i)){
            mRealMatrix.setEntry(getPosition().getX()-i, getPosition().getY()-i, HIT_VALUE);
            i++;
        }
        i=0;
        while(checkGoodBounds(getPosition(), i, -i)){
            mRealMatrix.setEntry(getPosition().getX()+i, getPosition().getY()-i, HIT_VALUE);
            i++;
        }
        i=0;
        while(checkGoodBounds(getPosition(), -i, i)){
            mRealMatrix.setEntry(getPosition().getX()-i, getPosition().getY()+i, HIT_VALUE);
            i++;
        }

    }



}
