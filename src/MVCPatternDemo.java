import main.controller.BoardController;
import main.model.BoardBase;
//import main.model.BoardStandard;
import main.view.BoardView;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description:
 */
public class MVCPatternDemo {
    public static void main(String args[]){
        // model
        BoardBase chessBoard = new BoardBase();
        // view
        BoardView boardView = new BoardView(chessBoard);
        // controller
        BoardController controller = new BoardController(boardView);
    }
}