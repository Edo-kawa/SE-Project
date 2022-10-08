package src.main.model.Chesses;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Chess {
    private int x;
    private int y;
    private final Animal animal;

    public Chess(int x, int y, Animal animal){
        this.x = x;
        this.y = y;
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
