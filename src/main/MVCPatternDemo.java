package src.main;

import src.main.controller.BoardController;
import src.main.model.BoardStandard;
import src.main.view.BoardView;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description:
 */
public class MVCPatternDemo {
    public static void main(String args[]){
        // model
        BoardStandard boardStandard = new BoardStandard();
        // view
        BoardView boardView = new BoardView();
        // controller
        BoardController controller = new BoardController(boardStandard, boardView);
    }
}
