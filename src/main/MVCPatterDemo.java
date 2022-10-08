package main;

import src.main.controller.ChessBoardController;
import src.main.model.ChessBoard;
import src.main.view.ChessBoardView;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class MVCPatterDemo {
    public static void main(String[] args) {
        ChessBoard model = init();
        ChessBoardView view = new ChessBoardView();
        ChessBoardController controller = new ChessBoardController(model, view);

        controller.updateView();

        // let's say we try to move a chess
        // i.e. try to modify by using setter
        controller.updateView();
    }

    private static ChessBoard init(){
        return new ChessBoard();
    }
}
