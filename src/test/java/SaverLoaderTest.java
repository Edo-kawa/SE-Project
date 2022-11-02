import controller.BoardController;
import model.ChessBoard;
import org.junit.Test;

import utils.SaverLoader;
import view.BoardView;

import static org.junit.jupiter.api.Assertions.*;

public class SaverLoaderTest {
    @Test
    public void checkSaverAndLoader() {
        // Initialization
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.init(null);
        BoardView boardView = new BoardView(chessBoard);
        BoardController boardController = new BoardController(boardView);
        assert true;

        // Test loading only with invalid file names or with both invalid file names and invalid BoardViews
        assertNull(SaverLoader.load(null, null));
        assertNull(SaverLoader.load("FileNotExist", null));
        assertNull(SaverLoader.load(null, new BoardView(new ChessBoard())));
        assertNull(SaverLoader.load("FileNotExist", new BoardView(new ChessBoard())));

        // Test whether the saving process can work
        SaverLoader.save("UnitTest1", 1, chessBoard.getPositions());
        SaverLoader.save("UnitTest2", 2, chessBoard.getPositions());
        assert true;

        // Test whether the original positions and the loaded positions are identical or not
        BoardController LoadBC1 = SaverLoader.load("UnitTest1", boardView);
        BoardController LoadBC2 = SaverLoader.load("UnitTest2", boardView);
        assertNotNull(LoadBC1);
        assertNotNull(LoadBC2);
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 9; j++) {
                assertEquals(boardController.getModel().getPositions()[i][j], LoadBC1.getModel().getPositions()[i][j]);
                assertEquals(boardController.getModel().getPositions()[i][j], LoadBC2.getModel().getPositions()[i][j]);
            }
        }
    }
}
