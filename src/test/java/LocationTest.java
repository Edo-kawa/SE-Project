import model.Pieces.Animal;
import model.Pieces.Piece;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import utils.Location;
import utils.Side;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: Test for the class Location.
 */

public class LocationTest {

    Location location1, location2, location3, location4,
    location5, location6, location7;

    @BeforeEach
    void setUp(){
        location1 = new Location(2, 3);
        location2 = new Location(1, 1);
        location3 = new Location(62);
    }

    @Test
    // Test if the index and row/column can be converted
    // to one another correctly.
    void testLocationCorrectness(){
        assertEquals(9, location1.getIndex());
        assertEquals(0, location2.getIndex());
        assertEquals(9, location3.getRow());
        assertEquals(7, location3.getCol());
    }

    @Test
    // Test if there would be exception if the location in invalid.
    void testException(){

        Throwable exception1 = assertThrows(RuntimeException.class, () -> location4 = new Location(10, 3));
        assertEquals("Illegal access", exception1.getMessage());
        Throwable exception2 = assertThrows(RuntimeException.class, () -> location5 = new Location(9, 8));
        assertEquals("Illegal access", exception2.getMessage());
        Throwable exception3 = assertThrows(RuntimeException.class, () -> location6 = new Location(-1));
        assertEquals("Illegal access", exception3.getMessage());
        Throwable exception4 = assertThrows(RuntimeException.class, () -> location7 = new Location(63));
        assertEquals("Illegal access", exception4.getMessage());
    }

    @Test
    // Test if two locations are equal if they have the same index/(row, col)
    void testLocationComparison(){

        // Should be equal
        assertEquals(location1, new Location(2,3));
        assertEquals(location1, new Location(9));
        assertEquals(location2, new Location(1,1));
        assertEquals(location2, new Location(0));
        assertEquals(location3, new Location(62));
        assertEquals(location3, new Location(9,7));

        // Should not be equal
        assertNotEquals(location1, new Location(0));
        assertNotEquals(location2, new Location(9, 1));
        assertNotEquals(location3, new Location(61));
        assertFalse(location3.equals(new Piece(Animal.WOL, Side.Red)));
    }

    @Test
    // Test ParseIndex static method.
    void testParseIndex(){
        assertEquals(new Location(2, 6), Location.parseIndex(12));
        assertEquals(new Location(1, 1), Location.parseIndex(0));
        assertEquals(new Location(9,7), Location.parseIndex(62));
        Throwable exception1 = assertThrows(RuntimeException.class, () -> Location.parseIndex(63));
        assertEquals("Illegal access", exception1.getMessage());
        Throwable exception2 = assertThrows(RuntimeException.class, () -> Location.parseIndex(-1));
        assertEquals("Illegal access", exception2.getMessage());
    }

    @Test
    void testHashCode(){
        Location x = new Location(2, 3);
        Location y = new Location(2,3);
        assertTrue(x.equals(y) && y.equals(x));
        assertTrue(x.hashCode() == y.hashCode());
    }

}
