import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import utils.Location;

/**
 * @Author Anthony Z.
 * @Date 27/10/2022
 * @Description:
 */

public class LocationTest {

    Location location;

    @BeforeEach
    void setUp(){
        location = new Location(2, 3);
    }

    @Test
    void testGetIndex(){
        assertEquals(9, location.getIndex());
    }
    @Test
    void testLocationComparison(){
        assertEquals(location, new Location(2,3));
    }
}
