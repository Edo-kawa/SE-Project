package main.model.Chesses;

import main.utils.Location;
import main.utils.Side;

import static main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Wolf extends Chess{
    public Wolf(Location location, Side side) {
        super(location, WOL, side);
    }
    public boolean isValidPath(Location from, Location to){
        return false;
    }
}
