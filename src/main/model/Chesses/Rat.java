package src.main.model.Chesses;

import src.main.model.Square;
import src.main.model.Type;
import src.main.utils.Side;

import static java.lang.Math.abs;
import static src.main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Rat extends Chess {
    public Rat(int x, int y, Side side) {
        super(x, y, RAT, side);
    }
    public boolean isValidPath(int nextX, int nextY){
        return false;
    }

    public boolean canMoveToEmpty(int dx, int dy, Square square){
        if(dx<1 || dx>9 || dy<1 || dy>7){
            return false;
        }
        if(square.getType()==Type.DEN1 && side == Side.Red){
            return false;
        }
        if(square.getType()==Type.DEN2 && side == Side.Blue){
            return false;
        }
        if(dx==location.getRow() && abs(dy-location.getCol())==1){
            return true;
        }
        if(dy==location.getCol() && abs(dx-location.getRow())==1){
            return true;
        }
        return false;
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()==1 || animal1.getRank()==8;
    }
}
