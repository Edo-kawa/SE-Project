package model.Pieces;

import utils.*;
import static model.Pieces.Animal.ELE;

public class Elephant extends Piece {
    public Elephant(Side side) {
        super(ELE, side);
    }

    /**
     *
     * @param animal1 the other animal
     * @return true if the other animal is not a rat
     */
    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
