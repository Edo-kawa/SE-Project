import model.Pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.*;

import java.lang.reflect.Method;

import static model.Pieces.Animal.DOG;
import static model.Pieces.Animal.RAT;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *  This is the test for the class Elephant.
 */
public class ElephantTest{

    Elephant elephant1,elephant2;

    @BeforeEach
    void setUp(){
        // Setup
        elephant1 = new Elephant(Side.Blue);
        elephant2 = new Elephant(Side.Red);
    }

    @Test
    void checkElephant(){
        // Test if Elephant class is valid
        assertEquals(elephant1,new Piece(Animal.ELE,Side.Blue));
        assertEquals(elephant2,new Piece(Animal.ELE,Side.Red));
    }

    @Test
    void testOutRank(){
        Class c = elephant1.getClass();
        try{
            Method method = c.getDeclaredMethod("outRank", new Class[]{Animal.class});
            method.setAccessible(true);
            Object result1 = method.invoke(elephant1, new Object[]{DOG});
            assertEquals(true, result1);
            Object result2 = method.invoke(elephant1, new Object[]{RAT});
            assertEquals(false, result2);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}



