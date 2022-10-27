package model.Pieces;

import utils.*;

import model.Pieces.Animal;
import static model.Pieces.Animal.ELE;

public class Elephant extends Piece {
    public Elephant(Location location, Side side) {
        super(location, ELE, side);
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
