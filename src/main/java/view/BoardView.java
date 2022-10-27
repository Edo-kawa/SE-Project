package view;

import main.model.ChessBoard;
//import main.model.BoardStandard;
import main.utils.Location;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class BoardView {
    private ChessBoard chessBoard;

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public BoardView(ChessBoard model){
        chessBoard=model;
    }

    public void printChessBoard(){
        System.out.println("----------------------------");
        for(int r=9; r>=1; r--){
            System.out.print(" "+r+" - ");
            for(int c=1; c<=7; c++){
                System.out.print(chessBoard.getSquare(new Location(r, c)));
            }
            System.out.println();
        }
        System.out.println("      |  |  |  |  |  |  | ");
        System.out.println("      1  2  3  4  5  6  7 ");
        System.out.println("----------------------------");
    }
}
