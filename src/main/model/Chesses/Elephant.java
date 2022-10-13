package src.main.model.Chesses;

import src.main.utils.Location;
import src.main.utils.Side;

import static src.main.model.Chesses.Animal.*;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Elephant extends Chess{
    public Elephant(Location location, Side side) {
        super(location, ELE, side);
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
