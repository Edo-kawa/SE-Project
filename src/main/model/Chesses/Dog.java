package main.model.Chesses;

import main.utils.Location;
import main.utils.Side;

import static main.model.Chesses.Animal.*;

public class Dog extends Chess{
    public Dog(Location location, Side side) {
        super(location, DOG, side);
    }
}
