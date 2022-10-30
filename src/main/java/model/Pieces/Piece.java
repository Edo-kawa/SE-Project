package model.Pieces;

import static java.lang.Math.abs;
import model.*;
import utils.*;

public class Piece {

    protected Side side;
    public Side getSide(){
        return side;
    }
    private final Animal animal;

    public Piece(Animal animal, Side owner){
        this.animal = animal;
        this.side=owner;
    }

    public String toString() {
        return animal.toString();
    }

    public Animal getAnimal() {
        return animal;
    }

    /**
     * checks whether it is possible to move to an empty square
     * overridden in RAT, TIG, LIO
     * @param destination the destination location
     * @param square the destination square
     * @return true if possible, false if impossible
     */
    public boolean canMoveToEmpty(Location original, Location destination, Square square){

        int dx = destination.getRow();
        int dy = destination.getCol();
        int x = original.getRow();
        int y = original.getCol();

        if(square.getType()== Type.RIVER){
            return false;
        }
        if(square.getType()==Type.DEN1 && side == Side.Red){
            return false;
        }
        if(square.getType()==Type.DEN2 && side == Side.Blue){
            return false;
        }

        if(dx==x && abs(dy-y)==1){
            return true;
        }
        return dy == y && abs(dx - x) == 1;
    }


    /**
     * This method would be overridden in RAT & ELE
     * @param animal1 the other animal
     * @return true if it is possible to take a piece
     */
    protected boolean outRank(Animal animal1){
        return animal.getRank()>=animal1.getRank();
    }

    /**
     * checks whether it is possible to take a piece on a square
     * special cases to be handled by chessboard:
     * 1. Capturing a rat in the river from land
     * 2. Rat in river capturing piece on land
     * @param square the square that contains the target
     * @return true if it is possible to take a piece on a square
     */
    public boolean canTake(Square square){
        if(square.getChessContent().getSide() == this.side){
            return false;
        }
        switch (square.getType()){
            case NORMAL:
                return outRank(square.getChessContent().getAnimal());
            case RIVER:
                return true;

            case TRAP1:
                if(side == Side.Red){
                    return true;
                }else{
                    return outRank(square.getChessContent().getAnimal());
                }

            case TRAP2:
                if(side == Side.Blue){
                    return true;
                }else{
                    return outRank(square.getChessContent().getAnimal());
                }
        }
        return true;
    }
}
