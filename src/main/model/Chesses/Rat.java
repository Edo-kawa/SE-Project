package src.main.model.Chesses;

import src.main.model.Square;
import src.main.model.Type;

import static java.lang.Math.abs;
import static src.main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Rat extends Chess {
    public Rat(int x, int y, int owner) {
        super(x, y, RAT, owner);
    }
    public boolean isValidPath(int nextX, int nextY){
        return false;
    }

    public boolean canMoveToEmpty(int dx, int dy, Square square){
        if(dx<1 || dx>9 || dy<1 || dy>7){
            return false;
        }
        if(square.getType()==Type.DEN1 && owner==1){
            return false;
        }
        if(square.getType()==Type.DEN2 && owner==2){
            return false;
        }
        if(dx==x && abs(dy-y)==1){
            return true;
        }
        if(dy==y && abs(dx-x)==1){
            return true;
        }
        return false;
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()==1 || animal1.getRank()==8;
    }
}
