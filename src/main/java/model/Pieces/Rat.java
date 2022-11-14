package model.Pieces;

import model.*;
import utils.*;

import static java.lang.Math.abs;
import static model.Pieces.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Rat extends Piece {
    public Rat(Side side) {
        super(RAT, side);
    }

    /**
     *
     * @param from the starting location
     * @param destination the destination location
     * @param square the destination square
     * @return true if the piece can move to the specified destination; false otherwise
     */
    public boolean canMoveToEmpty(Location from, Location destination, Square square){
        int dx = destination.getRow();
        int dy = destination.getCol();

        if(square.getType()==Type.DEN1 && super.side == Side.Red){
            return false;
        }
        if(square.getType()==Type.DEN2 && super.side == Side.Blue){
            return false;
        }
        if(dx==from.getRow() && abs(dy-from.getCol())==1){
            return true;
        }
        return dy == from.getCol() && abs(dx - from.getRow()) == 1;
    }

    /**
     *
     * @param animal1 the other animal
     * @return true if the other animal is a rat or an elephant
     */
    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()==1 || animal1.getRank()==8;
    }
}
