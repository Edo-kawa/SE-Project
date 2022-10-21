package main.model.Pieces;

import static java.lang.Math.abs;
import main.model.Square;
import main.model.Type;
import main.utils.Location;
import main.utils.Side;

public class Piece {
    protected Location location;

    // Red/Blue
    protected Side side;
    public Side getSide(){
        return side;
    }

    // Represents for which animal
    public final Animal animal;

    public Piece(Location location, Animal animal, Side owner){
        this.location = location;
        this.animal = animal;
        this.side=owner;
    }

    @Override
    /**
     * @return the name of animal represented by the piece
      */
    public String toString() {
        return animal.toString();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * checks whether it is possible to move to an empty
     * overridden in RAT, TIG, LIO according to the rule
     * @param destination
     * @param square
     * @return true if the destination is reachable and is not river square or the self den; false otherwise
     */
    public boolean canMoveToEmpty(Location original, Location destination, Square square);

    /**
     * checks which piece has a higher rank
     * overriden in RAT & ELE according to the rule
     * @param animal1
     * @return true if it is possible to take a piece; false otherwise
     */
    protected boolean outRank(Animal animal1){
        return animal.getRank()>=animal1.getRank();
    }

    /**
     * checks whether it is possible to take a piece on a square
     *
     * special cases to be handled by chessboard:
     * 1. Capturing a rat in the river from land
     * 2. Rat in river capturing piece on land
     * @param square
     * @return true if it is possible to take a piece on a square; false otherwise
     */
    public boolean canTake(Square square);
}
