import model.Pieces.*;
import model.Square;
import model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Location;
import utils.Side;

import java.lang.reflect.Method;

import static model.Pieces.Animal.DOG;
import static model.Pieces.Animal.ELE;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  This is the test for the class Rat.
 */
public class RatTest {
    Rat rat1,rat2;
    Location location1,location2,location3,location4;
    Square square1,square2,square3;

    @BeforeEach
    void setup() {
        // Setup
        rat1 = new Rat(Side.Red);
        rat2 = new Rat(Side.Blue);
        location1 = new Location(2,5);
        location2 = new Location(2,6);
        location3 = new Location(7,1);
        location4 = new Location(6,1);
        square1 = new Square(new Piece(Animal.RAT, Side.Red), Type.NORMAL);
        square2 = new Square(new Piece(Animal.RAT, Side.Red), Type.DEN1);
        square3 = new Square(new Piece(Animal.RAT, Side.Red), Type.DEN2);

    }

    @Test
    void checkRat() {
        // Test canMoveToEmpty() with different cases
        // Red side in Den1 is invalid
        assertFalse(rat1.canMoveToEmpty(location1,location2,square2));
        // Blue side in Den2 is invalid
        assertFalse(rat2.canMoveToEmpty(location1,location2,square3));
        // Same row move 1 column is valid
        assertTrue(rat2.canMoveToEmpty(location1,location2,square1));
        // Same column move 1 row is valid
        assertTrue(rat2.canMoveToEmpty(location3,location4,square1));

    }
    @Test
    void testOutRank(){
        Class c = rat1.getClass();
        try{
            Method method = c.getDeclaredMethod("outRank", new Class[]{Animal.class});
            method.setAccessible(true);
            Object result1 = method.invoke(rat1, new Object[]{ELE});
            assertEquals(true, result1);
            Object result2 = method.invoke(rat1, new Object[]{DOG});
            assertEquals(false, result2);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}