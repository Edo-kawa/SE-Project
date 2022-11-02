import model.Pieces.*;
import model.Square;
import model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Location;
import utils.Side;

import static org.junit.jupiter.api.Assertions.*;


public class LionTest {


    Lion lion1,lion2;
    Square square1, square2, square3, square4;
    Location location1,location2,location3,location4,location5,location6,location7,location8;

    @BeforeEach
    void test() {
        lion1 = new Lion(Side.Red);
        lion2 = new Lion(Side.Blue);
        location1 = new Location(1,7);
        location2 = new Location(1,6);
        location3 = new Location(7,1);
        location4 = new Location(8,1);
        location5 = new Location(5,7);
        location6 = new Location(5,4);
        location7 = new Location(3,2);
        location8 = new Location(7,2);
        square1 = new Square(new Piece(Animal.LIO, Side.Red), Type.NORMAL);
        square2 = new Square(new Piece(Animal.LIO, Side.Red), Type.RIVER);
        square3 = new Square(new Piece(Animal.LIO, Side.Red), Type.DEN1);
        square4 = new Square(new Piece(Animal.LIO, Side.Blue), Type.DEN2);
    }

    @Test
    void checkLion() {
        assertEquals(lion1, new Piece(Animal.LIO, Side.Red));
        assertEquals(lion2, new Piece(Animal.LIO, Side.Blue));
    }

    @Test
    void testcanMovetoEmpty() {

        assertFalse(lion1.canMoveToEmpty(location1,location2,square2));
        assertFalse(lion1.canMoveToEmpty(location1,location2,square3));
        assertFalse(lion2.canMoveToEmpty(location1,location2,square4));
        assertTrue(lion1.canMoveToEmpty(location1,location2,square1));
        assertTrue(lion1.canMoveToEmpty(location3,location4,square1));
        assertTrue(lion1.canMoveToEmpty(location5,location6,square1));
        assertTrue(lion1.canMoveToEmpty(location7,location8,square1));


    }
}

