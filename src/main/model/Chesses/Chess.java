package src.main.model.Chesses;

import src.main.utils.Location;
import src.main.utils.Side;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Chess {
    private Location location;

//    private int owner;//player: 1 or 2

    private Side side;
    public Side getSide(){
        return side;
    }
    private final Animal animal;

    public Chess(int x, int y, Animal animal, Side side){
        this.location = new Location(x, y);
        this.animal = animal;
        this.side = side;
    }

    @Override
    public String toString() {
        return animal.toString();
    }

    public Animal getAnimal() {
        return animal;
    }



}
