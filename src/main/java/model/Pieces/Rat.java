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
    public Rat(Location location, Side side) {
        super(location, RAT, side);
    }
    public boolean isValidPath(int nextX, int nextY){
        return false;
    }

    public boolean canMoveToEmpty(Location from, Location destionation, Square square){
        int dx = destionation.getRow();
        int dy = destionation.getCol();

        if(dx<1 || dx>9 || dy<1 || dy>7){
            return false;
        }
        if(square.getType()==Type.DEN1 && super.side == Side.Red){
            return false;
        }
        if(square.getType()==Type.DEN2 && super.side == Side.Blue){
            return false;
        }
//        System.out.println(getLocation().getRow());
//        System.out.println(getLocation().getCol());
        if(dx==from.getRow() && abs(dy-from.getCol())==1){
            return true;
        }
        if(dy==from.getCol() && abs(dx-from.getRow())==1){
            return true;
        }
        return false;
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()==1 || animal1.getRank()==8;
    }
}
