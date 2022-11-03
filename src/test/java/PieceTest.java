import model.Pieces.*;
import model.Square;
import model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Location;
import utils.Side;

import static org.junit.jupiter.api.Assertions.*;


public class PieceTest {

    Piece leo,wol,dog,cat;
    Square square1, square2, square3, square4, square5, square6, square7, square8;
    Location location1,location2,location3,location4;

    @BeforeEach
    void setup() {
        leo = new Piece(Animal.LEO,Side.Red);
        wol = new Piece(Animal.WOL,Side.Red);
        dog = new Piece(Animal.DOG,Side.Blue);
        cat = new Piece(Animal.CAT,Side.Blue);

        location1 = new Location(1,7);
        location2 = new Location(1,6);
        location3 = new Location(7,1);
        location4 = new Location(8,1);
        square1 = new Square(new Piece(Animal.LEO, Side.Red), Type.NORMAL);
        square2 = new Square(new Piece(Animal.WOL, Side.Red), Type.RIVER);
        square3 = new Square(new Piece(Animal.DOG, Side.Blue), Type.DEN1);
        square4 = new Square(new Piece(Animal.CAT, Side.Blue), Type.DEN2);
        square5 = new Square(new Piece(Animal.CAT, Side.Red), Type.TRAP1);
        square6 = new Square(new Piece(Animal.CAT, Side.Blue), Type.TRAP1);
        square7 = new Square(new Piece(Animal.CAT, Side.Red), Type.TRAP2);
        square8 = new Square(new Piece(Animal.CAT, Side.Blue), Type.TRAP2);

    }


    @Test
    void testcanMovetoEmpty() {

        assertFalse(leo.canMoveToEmpty(location1,location2,square2));
        assertFalse(wol.canMoveToEmpty(location1,location2,square3));
        assertFalse(dog.canMoveToEmpty(location1,location2,square4));
        assertTrue(cat.canMoveToEmpty(location1,location2,square1));
        assertTrue(cat.canMoveToEmpty(location3,location4,square1));

    }


    @Test
    void testcanTake() {

        assertFalse(leo.canTake(square2));
        assertFalse(dog.canTake(square1));
        assertTrue(dog.canTake(square2));
        assertTrue(dog.canTake(square5));
        assertTrue(leo.canTake(square6));
        assertTrue(dog.canTake(square7));
        assertTrue(leo.canTake(square8));
        assertTrue(leo.canTake(square3));

    }

}