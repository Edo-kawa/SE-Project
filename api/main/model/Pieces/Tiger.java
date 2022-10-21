package main.model.Pieces;

import main.model.Square;
import main.model.Type;
import main.utils.Location;
import main.utils.Side;

import static java.lang.Math.abs;
import static main.model.Pieces.Animal.*;

public class Tiger extends Piece {
    public Tiger(Location location, Side side) {
        super(location, TIG, side);
    }

    public boolean canMoveToEmpty(Location original, Location destination, Square square);
}
