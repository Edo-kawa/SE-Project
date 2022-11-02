import model.Pieces.*;
import model.Square;
import model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Location;
import utils.Side;

import static org.junit.jupiter.api.Assertions.*;

public class RatTest {
    Rat rat1,rat2;
    Location location1,location2,location3;
    Square square1,square2,square3;

    @BeforeEach
    void test() {
        rat1 = new Rat(Side.Red);
        rat2 = new Rat(Side.Blue);
        location1 = new Location(2,5);
        location2 = new Location(2,6);
        location3 = new Location(7,1);

        square1 = new Square(new Piece(Animal.RAT, Side.Red), Type.NORMAL);
        square2 = new Square(new Piece(Animal.RAT, Side.Red), Type.DEN1);
        square3 = new Square(new Piece(Animal.RAT, Side.Red), Type.DEN2);

    }

    @Test
    void checkRat() {

        assertFalse(rat1.canMoveToEmpty(location1,location2,square2));
        assertFalse(rat2.canMoveToEmpty(location1,location2,square3));
        assertTrue(rat2.canMoveToEmpty(location1,location2,square1));


    }

}