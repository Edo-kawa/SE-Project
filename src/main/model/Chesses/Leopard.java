package src.main.model.Chesses;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Leopard extends Chess{
    public Leopard(int x, int y, Animal animal) {
        super(x, y, animal);
    }
    boolean isValidPath(int x, int y){
        return false;
    }
}
