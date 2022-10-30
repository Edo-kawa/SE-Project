package model.Pieces;

import utils.*;
import static model.Pieces.Animal.ELE;

public class Elephant extends Piece {
    public Elephant(Side side) {
        super(ELE, side);
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
