package src.main.model.Chesses;

import static src.main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Wolf extends Chess{
    public Wolf(int x, int y, int owner) {
        super(x, y, WOL, owner);
    }
    boolean isValidPath(int x, int y){
        return false;
    }
}
