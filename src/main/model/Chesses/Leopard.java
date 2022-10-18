package main.model.Chesses;

import main.utils.Location;
import main.utils.Side;

import static main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Leopard extends Chess{
    public Leopard(Location location, Side side) {
        super(location, LEO, side);
    }
    boolean isValidPath(Location from, Location to){
        return false;
    }
}
