import controller.BoardController;
import model.ChessBoard;
import view.BoardView;

public class MVCPatternDemo {
    public static void main(String[] args){
        // model
        ChessBoard chessBoard = new ChessBoard();
        // view
        BoardView boardView = new BoardView(chessBoard);
        // controller
        BoardController controller;
        do {
            controller = BoardController.getController(boardView);
            if (controller == null) {
                System.out.println("End!");
                return;
            }
            controller.startPlaying();
        } while (controller.ifCont());

        System.out.println("End!");
    }
}