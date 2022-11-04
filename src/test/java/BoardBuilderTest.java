import model.Pieces.*;
import org.junit.jupiter.api.Test;
import utils.BoardBuilder;
import utils.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Description:  @Description: Test for the chess factory.
 *
 * The
 */
public class BoardBuilderTest {

    BoardBuilder boardBuilder;

    @Test // Test if chess factory can produce the expected piece.
    // based on the String and Side as the parameter.
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

    @Test // Test if chess factory would return null if the piece name is wrong.
    // If null, the factory should output null.
    void checkInvalidInput(){
        assertNull(BoardBuilder.chessFactory("Rabbit", Side.Red), "Invalid input checked");
        assertNull(BoardBuilder.chessFactory("Dragon", Side.Blue), "Invalid input checked");
        assertNull(BoardBuilder.chessFactory("Ele", Side.Red), "Invalid input checked");

    }


}
