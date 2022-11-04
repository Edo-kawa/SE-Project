import model.Pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElephantTest{

    Elephant elephant1,elephant2;

    @BeforeEach
    void setUp(){
        //Setup
        elephant1 = new Elephant(Side.Blue);
        elephant2 = new Elephant(Side.Red);
    }

    @Test
    void checkElephant(){
        //Test if Elephant class is valid
        assertEquals(elephant1,new Piece(Animal.ELE,Side.Blue));
        assertEquals(elephant2,new Piece(Animal.ELE,Side.Red));
    }


}

