package main.model.Pieces;

import main.utils.Location;
import main.utils.Side;

import static main.model.Pieces.Animal.*;
public class Elephant extends Piece {
    public Elephant(Location location, Side side) {
        super(location, ELE, side);
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
