import model.Pieces.*;
import org.junit.jupiter.api.Test;
import utils.BoardBuilder;
import utils.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Description: Test for the chess factory.
 */
public class BoardBuilderTest {

    BoardBuilder boardBuilder;

    /**
     *  Test if chess factory can produce the expected piece.
     */
    @Test
    void checkEquals(){
        assertEquals(BoardBuilder.chessFactory("ELE", Side.Red), new Elephant(Side.Red));
        assertEquals(BoardBuilder.chessFactory("LIO", Side.Blue), new Lion(Side.Blue));
        assertEquals(BoardBuilder.chessFactory("LEO", Side.Red), new Piece(Animal.LEO, Side.Red));
        assertEquals(BoardBuilder.chessFactory("DOG", Side.Blue), new Piece(Animal.DOG, Side.Blue));
        assertEquals(BoardBuilder.chessFactory("RAT", Side.Red), new Rat(Side.Red));
        assertEquals(BoardBuilder.chessFactory("WOL", Side.Blue), new Piece(Animal.WOL, Side.Blue));
        assertEquals(BoardBuilder.chessFactory("TIG", Side.Red), new Tiger(Side.Red));
        assertEquals(BoardBuilder.chessFactory("CAT", Side.Blue), new Piece(Animal.CAT, Side.Blue));
    }

    /**
     *  Test if chess factory would return null if the piece name is wrong.
     */
    @Test
    void checkInvalidInput(){
        assertNull(BoardBuilder.chessFactory("Rabbit", Side.Red), "Invalid input checked");
        assertNull(BoardBuilder.chessFactory("Dragon", Side.Blue), "Invalid input checked");
        assertNull(BoardBuilder.chessFactory("Ele", Side.Red), "Invalid input checked");

    }


}
