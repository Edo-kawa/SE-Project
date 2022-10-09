package src.main.model.Chesses;

import static src.main.model.Chesses.Animal.*;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Elephant extends Chess{
    public Elephant(int x, int y, int owner) {
        super(x, y, ELE, owner);
    }

    @Override
    protected boolean outRank(Animal animal1) {
        return animal1.getRank()!=1;
    }
}
