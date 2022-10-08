package src.main;

import src.main.controller.ChessBoardController;
import src.main.model.ChessBoard;
import src.main.model.Chesses.Chess;
import src.main.view.ChessBoardView;
import src.main.view.ConsoleColors;

import java.util.Scanner;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description:
 */
public class MVCPatternDemo {



    public static void main(String args[]){

        // model
        ChessBoard chessBoard = new ChessBoard();
        // view
        ChessBoardView chessBoardView = new ChessBoardView();
        // controller
        ChessBoardController controller = new ChessBoardController(chessBoard, chessBoardView);


    }
}
