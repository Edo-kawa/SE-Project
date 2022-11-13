import model.ChessBoard;
import model.Pieces.Animal;
import org.junit.jupiter.api.*;
import utils.Location;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  This is the test for the class ChessBoard.
 */
public class ChessBoardTest {
    private ChessBoard chessBoard1, chessBoard2;
    @BeforeEach
    void setup(){
        chessBoard1 = new ChessBoard();
        chessBoard2 = new ChessBoard();
    }

    /**
     *  Tests whether initialization of squares and positions is correct
     */
    @Test
    void init_and_getPosition_Test(){
        chessBoard1.init(null);
        assertEquals(chessBoard1.getPosition(0,3),new Location(2,6));
        assertEquals(chessBoard1.getPositions()[1][8],new Location(7,7));
        try{
            chessBoard1.getPosition(-1,-1);
            fail();
        }catch (RuntimeException e){
            assertTrue(true);
        }
        Location[][] locations = new Location[2][9];
        for(int i=0;i<=1;i++){
            for(int j=1;j<=8;j++){
                locations[i][j]=new Location(i*3+j/6+1,j%6+1);
            }
        }
        chessBoard2.init(locations);
        assertEquals(chessBoard2.getPosition(1,7),new Location(5,2));
    }

    /**
     *  tests whether clear() can remove the content of a square and set it to null
     */
    @Test
    void clearTest(){
        chessBoard1.init(null);
        // Originally, there is a tiger
        assertEquals(chessBoard1.getSquare(new Location(1,1)).
                        getPieceContent().getAnimal(),Animal.TIG);
        chessBoard1.clear(new Location(1,1));
        // It is cleared
        assertNull(chessBoard1.getSquare(new Location(1, 1)).
                getPieceContent());

        // Same thing for the other player
        assertEquals(chessBoard1.getSquare(new Location(8,6)).
                getPieceContent().getAnimal(),Animal.CAT);
        chessBoard1.clear(new Location(8,6));
        assertNull(chessBoard1.getSquare(new Location(8, 6)).
                getPieceContent());
    }

    /**
     *  Tests whether moveTo() can empty the origin square and move the piece to destination
     */
    @Test
    void MoveToTest(){
        chessBoard1.init(null);
        // target is originally empty
        assertNull(chessBoard1.getSquare(new Location(1, 2)).
                getPieceContent());
        chessBoard1.moveTo(new Location(1,1), new Location(1,2));
        // target is filled after moveTo()
        assertEquals(chessBoard1.getSquare(new Location(1,2)).
                getPieceContent().getAnimal(),Animal.TIG);
        chessBoard1.moveTo(new Location(1,7),new Location(1,2));
        // target is again updated
        assertEquals(chessBoard1.getSquare(new Location(1,2)).
                getPieceContent().getAnimal(),Animal.LIO);

        // Originally (8,6) contains a cat
        assertEquals(chessBoard1.getSquare(new Location(8,6)).
                getPieceContent().getAnimal(), Animal.CAT);
        chessBoard1.moveTo(new Location(8,6), new Location(8,5));
        // After the move, it contains nothing
        assertNull(chessBoard1.getSquare(new Location(8, 6)).
                getPieceContent());
    }

    /**
     *  Tests whether checkLegalMove() functions as expected
     */
    @Test
    void checkLegalMoveTest(){
        // Normal situations
        chessBoard1.init(null);
        assertTrue(chessBoard1.checkLegalMove(new Location(1,1),new Location(1,2)));
        assertFalse(chessBoard1.checkLegalMove(new Location(1,1),new Location(2,2)));

        Location redTig=new Location(5,4);
        chessBoard1.moveTo(new Location(1,1),redTig);
        Location blueRat=new Location(5,5);
        chessBoard1.moveTo(new Location(7,1),blueRat);
        // Tiger moves into river
        assertFalse(chessBoard1.checkLegalMove(redTig,blueRat));
        // Jumps successfully
        assertTrue(chessBoard1.checkLegalMove(redTig,new Location(5,1)));
        // Jump is blocked by a rat in the river
        assertFalse(chessBoard1.checkLegalMove(redTig,new Location(5,7)));

        // Both adjacent squares are reachable
        assertTrue(chessBoard1.checkLegalMove(redTig,new Location(4,4)));
        assertTrue(chessBoard1.checkLegalMove(redTig,new Location(6,4)));
        Location blueCat=new Location(4,4);
        chessBoard1.moveTo(new Location(8,6),blueCat);
        Location redDog=new Location(5,1);
        chessBoard1.moveTo(new Location(2,6),redDog);
        Location blueEle=new Location(6,4);
        chessBoard1.moveTo(new Location(7,7),new Location(6,4));
        // Cannot take a friendly piece
        assertFalse(chessBoard1.checkLegalMove(redTig,redDog));
        // Can take an enemy piece that has inferior rank
        assertTrue(chessBoard1.checkLegalMove(redTig,blueCat));
        // Cannot take an enemy piece with superior rank
        assertFalse(chessBoard1.checkLegalMove(redTig,blueEle));

        // Moves red rat to (r5,c4)
        chessBoard1.moveTo(new Location(3,7),redTig);
        Location redRat=new Location(5,4);
        // Rats cannot attack each other when one but not both of them is in river
        assertFalse(chessBoard1.checkLegalMove(redRat,blueRat));
        assertFalse(chessBoard1.checkLegalMove(blueRat,redRat));

        // Vertical jump
        chessBoard1.moveTo(new Location(9,1),new Location(7,2));
        assertTrue(chessBoard1.checkLegalMove(new Location(7,2),new Location(3,2)));
        chessBoard1.moveTo(blueRat,new Location(4,2));
        assertFalse(chessBoard1.checkLegalMove(new Location(7,2),new Location(3,2)));
    }

    /**
     *  tests the end game condition
     */
    @Test
    void checkWinnerTest(){
        chessBoard1.init(null);
        // Default situation
        assertEquals(chessBoard1.checkWinner(),0);

        // Player Red moves into the Blue den
        chessBoard1.moveTo(new Location(1,1),new Location(9,4));
        assertEquals(chessBoard1.checkWinner(),1);

        // Player Blue moves into the Red den
        chessBoard1.moveTo(new Location(9,4),new Location(1,1));
        chessBoard1.moveTo(new Location(9,7),new Location(1,4));
        assertEquals(chessBoard1.checkWinner(),2);

        // Player Red loses all pieces
        chessBoard2.init(null);
        for(int i=1;i<=8;i++){
            chessBoard2.clear(chessBoard2.getPosition(0,i));
        }
        assertEquals(chessBoard2.checkWinner(),2);

        // Player Blue loses all pieces
        chessBoard2.init(null);
        for(int i=1;i<=8;i++){
            chessBoard2.clear(chessBoard2.getPosition(1,i));
        }
        assertEquals(chessBoard2.checkWinner(),1);
    }
}
