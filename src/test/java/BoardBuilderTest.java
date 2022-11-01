import model.Pieces.*;
import org.junit.jupiter.api.Test;
import utils.BoardBuilder;
import utils.Side;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @Author Anthony Z.
 * @Date 1/11/2022
 * @Description:
 */
public class BoardBuilderTest {

    BoardBuilder boardBuilder;

    @Test
    void checkEquals(){
        assertEquals(BoardBuilder.chessFactory("ELE", Side.Red), new Elephant(Side.Red));
        assertEquals(BoardBuilder.chessFactory("LIO", Side.Blue), new Lion(Side.Blue));
        assertEquals(BoardBuilder.chessFactory("LEO", Side.Red), new Piece(Animal.LEO, Side.Red));
        assertEquals(BoardBuilder.chessFactory("DOG", Side.Blue), new Piece(Animal.DOG, Side.Blue));
        assertEquals(BoardBuilder.chessFactory("RAT", Side.Red), new Rat(Side.Red));
    }

    @Test
    void checkInvalidInput(){
        assertNull(BoardBuilder.chessFactory("Rat", Side.Red), "Invalid input checked");
        assertNull(BoardBuilder.chessFactory("E", Side.Red), "Invalid input checked");

    }


}
