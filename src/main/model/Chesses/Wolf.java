package main.model.Chesses;

import main.utils.Location;
import main.utils.Side;

import static main.model.Chesses.Animal.*;
public class Wolf extends Chess{
    public Wolf(Location location, Side side) {
        super(location, WOL, side);
    }
}
