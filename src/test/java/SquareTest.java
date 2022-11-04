import model.Pieces.Animal;
import model.Pieces.Piece;
import model.Pieces.Rat;
import model.Square;
import model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Side;
import view.ConsoleColors;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;



public class SquareTest {
    Square square1, square2, square3, square4,
            square5, square6, square7, square8;


    @BeforeEach
    void test() {
        // All the Types
        //RIVER, TRAP1, TRAP2, DEN1, DEN2, NORMAL
        square1 = new Square(null, Type.RIVER);
        square2 = new Square(null, Type.TRAP1);
        square3 = new Square(null, Type.TRAP2);
        square4 = new Square(null, Type.DEN1);
        square5 = new Square(null, Type.DEN2);
        square6 = new Square(null, Type.NORMAL);
        square7 = new Square(new Piece(Animal.DOG, Side.Red), Type.NORMAL);
        square8 = new Square(new Piece(Animal.DOG, Side.Blue), Type.NORMAL);

    }

    @Test
    void testGettersAndSetters() {
        // test getters method in different circumstances.
        assertEquals(square1.getType(), Type.RIVER);
        assertNull(square1.getChessContent());
        assertNull(square2.getChessContent());
        assertNull(square3.getChessContent());
        assertEquals(square7.getChessContent(), new Piece(Animal.DOG, Side.Red));
        assertEquals(square8.getChessContent(), new Piece(Animal.DOG, Side.Blue));
        // test setters method in different circumstances.
        square6.setContent(new Piece(Animal.DOG, Side.Red));
        assertEquals(square6.getChessContent(), new Piece(Animal.DOG, Side.Red));

    }

    @Test
    void testToStringMethod() {

        String toString1 = square1.toString();
        String toString2 = square2.toString();
        String toString3 = square4.toString();
        String toString4 = square6.toString();
        String toString5 = square7.toString();
        String toString6 = square8.toString();

        assertEquals(ConsoleColors.CYAN_BACKGROUND + "   " + ConsoleColors.RESET, toString1);
        assertEquals(ConsoleColors.BLACK_BACKGROUND_BRIGHT + "   " + ConsoleColors.RESET, toString2);
        assertEquals(ConsoleColors.BLACK_BACKGROUND + "   " + ConsoleColors.RESET, toString3);
        assertEquals(ConsoleColors.GREEN_BACKGROUND + "   " + ConsoleColors.RESET, toString4);
        assertNotEquals(toString5, square7.getChessContent().toString());
        assertNotEquals(toString6, square8.getChessContent().toString());
    }

    @Test
    void testHashCode() {
        Square x = new Square(new Rat(Side.Red), Type.NORMAL);
        Square y = new Square(new Rat(Side.Red), Type.NORMAL);
        Map<Square, String> map = new HashMap<>();
        map.put(x, "Rat here");
        assertEquals("Rat here", map.get(y));
        assertNotEquals(x, new Square(new Piece(Animal.DOG, Side.Red), Type.NORMAL));
        assertFalse(x.equals(new Rat(Side.Red)));

    }
}