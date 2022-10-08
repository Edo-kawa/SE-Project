package src.main.model.Chesses;

import static src.main.model.Chesses.Animal.*;
/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Leopard extends Chess{
    public Leopard(int x, int y, int owner) {
        super(x, y, LEO, owner);
    }
    boolean isValidPath(int x, int y){
        return false;
    }
}
