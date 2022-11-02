import org.junit.jupiter.api.BeforeEach;
import utils.SaverLoader;
import view.BoardView;
import controller.BoardController;
import model.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SaverLoaderTest {
    private ChessBoard chessBoard;
    private BoardView boardView;
    private BoardController boardController;

    @BeforeEach
    void setUp() {
        this.chessBoard = new ChessBoard();
        this.chessBoard.init(null);
        this.boardView = new BoardView(this.chessBoard);
        this.boardController = new BoardController(this.boardView);
    }

    @Test
    void checkSaverAndLoader() {
        assertEquals(SaverLoader.SAVE_PATH, "./save/");

        // Test loading only with invalid file names or with both invalid file names and invalid BoardViews
        assertNull(SaverLoader.load(null, null));
        assertNull(SaverLoader.load("FileNotExist", null));
        assertNull(SaverLoader.load(null, new BoardView(new ChessBoard())));
        assertNull(SaverLoader.load("FileNotExist", new BoardView(new ChessBoard())));

        // Test save() with different cases
        // fileName is invalid:
        assertFalse(SaverLoader.save(null, 0, null));
        assertFalse(SaverLoader.save("*", 0, null));
        assertFalse(SaverLoader.save(".", 0, null));
        // playerTurn is invalid:
        assertFalse(SaverLoader.save("TestName", 0, null));
        assertFalse(SaverLoader.save("TestName", 3, null));
        // positions is null
        assertFalse(SaverLoader.save("TestName", 1, null));
        // All valid
        assertTrue(SaverLoader.save("TestName", 1, chessBoard.getPositions()));
        assertTrue(SaverLoader.save("UnitTest1", 1, chessBoard.getPositions()));
        assertTrue(SaverLoader.save("UnitTest2", 2, chessBoard.getPositions()));

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
