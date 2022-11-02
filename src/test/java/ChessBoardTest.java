import model.ChessBoard;
import model.Pieces.Animal;
import org.junit.jupiter.api.*;
import utils.Location;

import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {
    private ChessBoard chessBoard1, chessBoard2;
    @BeforeEach
    void setup(){
        chessBoard1 = new ChessBoard();
        chessBoard2 = new ChessBoard();
    }

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
    @Test
    void clearTest(){
        chessBoard1.init(null);
        assertEquals(chessBoard1.getSquare(new Location(1,1)).
                        getChessContent().getAnimal(),Animal.TIG);
        chessBoard1.clear(new Location(1,1));
        assertNull(chessBoard1.getSquare(new Location(1, 1)).
                getChessContent());
        assertEquals(chessBoard1.getSquare(new Location(8,6)).
                getChessContent().getAnimal(),Animal.CAT);
        chessBoard1.clear(new Location(8,6));
        assertNull(chessBoard1.getSquare(new Location(8, 6)).
                getChessContent());
    }

    @Test
    void MoveToTest(){
        chessBoard1.init(null);
        assertNull(chessBoard1.getSquare(new Location(1, 2)).
                getChessContent());
        chessBoard1.moveTo(new Location(1,1), new Location(1,2));
        assertEquals(chessBoard1.getSquare(new Location(1,2)).
                getChessContent().getAnimal(),Animal.TIG);
        chessBoard1.moveTo(new Location(1,7),new Location(1,2));
        assertEquals(chessBoard1.getSquare(new Location(1,2)).
                getChessContent().getAnimal(),Animal.LIO);
        assertEquals(chessBoard1.getSquare(new Location(8,6)).
                getChessContent().getAnimal(), Animal.CAT);
        chessBoard1.moveTo(new Location(8,6), new Location(8,5));
        assertNull(chessBoard1.getSquare(new Location(8, 6)).
                getChessContent());
    }

    @Test
    void checkLegalMoveTest(){
        chessBoard1.init(null);
        assertTrue(chessBoard1.checkLegalMove(new Location(1,1),new Location(1,2)));
        assertFalse(chessBoard1.checkLegalMove(new Location(1,1),new Location(2,2)));

        Location redTig=new Location(5,4);
        chessBoard1.moveTo(new Location(1,1),redTig);
        Location blueRat=new Location(5,5);
        chessBoard1.moveTo(new Location(7,1),blueRat);
        assertFalse(chessBoard1.checkLegalMove(redTig,blueRat));
        assertTrue(chessBoard1.checkLegalMove(redTig,new Location(5,1)));
        assertFalse(chessBoard1.checkLegalMove(redTig,new Location(5,7)));

        assertTrue(chessBoard1.checkLegalMove(redTig,new Location(4,4)));
        assertTrue(chessBoard1.checkLegalMove(redTig,new Location(6,4)));
        Location blueCat=new Location(4,4);
        chessBoard1.moveTo(new Location(8,6),blueCat);
        Location redDog=new Location(5,1);
        chessBoard1.moveTo(new Location(2,6),redDog);
        Location blueEle=new Location(6,4);
        chessBoard1.moveTo(new Location(7,7),new Location(6,4));
        assertFalse(chessBoard1.checkLegalMove(redTig,redDog));
        assertTrue(chessBoard1.checkLegalMove(redTig,blueCat));
        assertFalse(chessBoard1.checkLegalMove(redTig,blueEle));

        chessBoard1.moveTo(new Location(3,7),redTig);
        Location redRat=new Location(5,4);
        assertFalse(chessBoard1.checkLegalMove(redRat,blueRat));
        assertFalse(chessBoard1.checkLegalMove(blueRat,redRat));

        chessBoard1.moveTo(new Location(9,1),new Location(7,2));
        assertTrue(chessBoard1.checkLegalMove(new Location(7,2),new Location(3,2)));
        chessBoard1.moveTo(blueRat,new Location(4,2));
        assertFalse(chessBoard1.checkLegalMove(new Location(7,2),new Location(3,2)));
    }

    @Test
    void checkWinnerTest(){
        chessBoard1.init(null);
        assertEquals(chessBoard1.checkWinner(),0);

        chessBoard1.moveTo(new Location(1,1),new Location(9,4));
        assertEquals(chessBoard1.checkWinner(),1);

        chessBoard1.moveTo(new Location(9,4),new Location(1,1));
        chessBoard1.moveTo(new Location(9,7),new Location(1,4));
        assertEquals(chessBoard1.checkWinner(),2);

        chessBoard2.init(null);
        for(int i=1;i<=8;i++){
            chessBoard2.clear(chessBoard2.getPosition(0,i));
        }
        assertEquals(chessBoard2.checkWinner(),2);

        chessBoard2.init(null);
        for(int i=1;i<=8;i++){
            chessBoard2.clear(chessBoard2.getPosition(1,i));
        }
        assertEquals(chessBoard2.checkWinner(),1);
    }
}
