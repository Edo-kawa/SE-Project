package src.main.view;

import src.main.model.ChessBoard;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class ChessBoardView {

    public static void printChessBoard(ChessBoard board){
        System.out.println("----------------------------");
        for(int r=9; r>=1; r--){
            System.out.print(" "+r+" - ");
            for(int c=1; c<=7; c++){
                System.out.print(board.getSquare(r,c));
            }
            System.out.println();
        }
        System.out.println("      |  |  |  |  |  |  | ");
        System.out.println("      1  2  3  4  5  6  7 ");
        System.out.println("----------------------------");
    }
}
