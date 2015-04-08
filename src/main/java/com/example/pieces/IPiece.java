package com.example.pieces;

import com.example.common.Position;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by Toxa on 06.04.2015.
 */

/***
 * Interface for chess board pieces
 */
public interface IPiece {
    PiecesType getType();
    Position getPosition();
    void setPosition(Position position);
    int getIdentifier();
    RealMatrix getPieceMovementMatrix();
    void clearMatrix();
}
