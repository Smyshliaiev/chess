package com.example.pieces;

/**
 * Created by Toxa on 06.04.2015.
 */
public enum PiecesType {
    KING(0),
    QUEEN(1),
    BISHOP(2),
    ROOK(3),
    KNIGHT(4);

    private final int value;

    PiecesType(int val) {
        value = val;
    }
}
