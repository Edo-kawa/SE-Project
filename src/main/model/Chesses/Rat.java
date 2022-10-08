package src.main.model.Chesses;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Rat extends Chess {


    public Rat(int x, int y, Animal animal) {
        super(x, y, animal);
    }

    public boolean isValidPath(int nextX, int nextY){
        return false;
    }


}
