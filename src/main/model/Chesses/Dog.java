package main.model.Chesses;

import main.utils.Location;
import main.utils.Side;

import static main.model.Chesses.Animal.*;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Dog extends Chess{
    public Dog(Location location, Side side) {
        super(location, DOG, side);
    }

    boolean isValidPath(int x, int y){
        return false;
    }
}
