package main.model.Pieces;

import main.model.Square;
import main.model.Type;
import main.utils.Location;
import main.utils.Side;

import static java.lang.Math.abs;
import static main.model.Pieces.Animal.*;

public class Lion extends Piece {
    public Lion(Location location, Side side) {
        super(location, LIO, side);
    }

    public boolean canMoveToEmpty(Location from, Location to, Square square);
}
