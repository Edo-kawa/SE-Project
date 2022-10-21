package main.model.Pieces;

import main.model.Square;
import main.model.Type;
import main.utils.Location;
import main.utils.Side;

import static java.lang.Math.abs;
import static main.model.Pieces.Animal.*;

public class Rat extends Piece {
    public Rat(Location location, Side side) {
        super(location, RAT, side);
    }
    public boolean isValidPath(int nextX, int nextY){
        return false;
    }

    public boolean canMoveToEmpty(Location from, Location destionation, Square square);

    @Override
    protected boolean outRank(Animal animal1);
}
