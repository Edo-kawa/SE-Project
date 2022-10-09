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
public class Tiger extends Chess{
    public Tiger(int x, int y, int owner) {
        super(x, y, TIG, owner);
    }

    boolean isValidPath(int x, int y){
        return false;
    }

    public boolean canMoveToEmpty(int dx, int dy, Square square){
        if(dx<1 || dx>9 || dy<1 || dy>7){
            return false;
        }
        if(square.getType()== Type.RIVER){
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

        /**
         * Jump over the river
         * Special case to be checked by Chessboard: rat in the river
         */
        if(x>=4 && x<=6 && dx==x && abs(dy-y)==3){
            return true;
        }
        if((x==3 || x==7) && (y==2 || y==3 || y==5 || y==6) && y==dy && abs(x-dx)==4){
            return true;
        }

        return false;
    }

}
