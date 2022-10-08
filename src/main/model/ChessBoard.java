package src.main.model;

import java.util.ArrayList;

public class ChessBoard {
    final int ROW = 9;
    final int COL = 7;

    final int[][] RIVER_COORDINATES = new int[][]{
            {2, 4}, {2, 5}, {2, 6},
            {3, 4}, {3, 5}, {3, 6},
            {5, 4}, {5, 5}, {5, 6},
            {6, 4}, {6, 5}, {6, 6}
    };

    final int[][] DEN_COORDINATES = new int[][]{
            {4, 1}, {4, 9}
    };

    final int[][] TRAP_COORDINATES = new int[][]{
            {3, 1}, {4, 2}, {5, 1},
            {3, 9}, {4, 8}, {5, 9}
    };

    private ArrayList<Square> squares;

    public ChessBoard() {
        squares = new ArrayList<>(ROW*COL);
        init();
    }

    /**
     * @param row
     * @param column
     * @return the index in arrayList
     */
    private int coordinate2index(int row, int column){
        return 0;
    }

    void init(){


    }
}
