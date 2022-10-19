package main.model.Chesses;

import main.utils.Location;
import main.utils.Side;

import static main.model.Chesses.Animal.*;
public class Elephant extends Chess{
    public Elephant(Location location, Side side) {
        super(location, ELE, side);
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
