import controller.BoardController;
import model.ChessBoard;
//import main.model.BoardStandard;
import view.BoardView;


public class MVCPatternDemo {
    public static void main(String[] args){
        // model
        ChessBoard chessBoard = new ChessBoard();
        // view
        BoardView boardView = new BoardView(chessBoard);
        // controller
        BoardController controller = new BoardController(boardView);
        controller.init();
    }
}