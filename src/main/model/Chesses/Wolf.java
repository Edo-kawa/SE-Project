package src.main.model.Chesses;

import src.main.utils.Side;

import static src.main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Wolf extends Chess{
    public Wolf(int x, int y, Side side) {
        super(x, y, WOL, side);
    }
    boolean isValidPath(int x, int y){
        return false;
    }
}
