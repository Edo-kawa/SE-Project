package main.model;

import java.util.ArrayList;

public class ChessBoard {
    final static int ROW = 9;
    final static int COL = 7;

    final static int RIVER_R = 3;
    final static int RIVER_Y1 = 1;
    final static int RIVER_Y2 = 4;

    private ArrayList<Square> squares;

    public ChessBoard() {

        squares = new ArrayList<>(ROW*COL);

    }

    /**
     * @param row
     * @param column
     * @return the index in arrayList
     */
    private int coordinate2index(int row, int column){
        return 0;
    }
}
