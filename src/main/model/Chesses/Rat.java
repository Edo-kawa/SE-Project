package src.main.model.Chesses;

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


}
