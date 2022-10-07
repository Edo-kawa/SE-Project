package main.model.Chesses;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class Cat extends Chess{
    public Cat(int x, int y, Animal animal) {
        super(x, y, animal);
    }


    // try
    public static void main(String[] args) {
        Chess chess = new Cat(2, 3, Animal.ART);

        System.out.println(chess.getAnimal().getRank());
    }


}
