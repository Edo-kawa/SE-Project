package src.main.utils;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description: Represent a directed change of location
 */
public class Vector extends Pair<Integer, Integer>{

    /**
     *
     * @param vertical  The vertical increment
     * @param horizontal  The horizontal increment
     */
    public Vector(int vertical, int horizontal) {
        super(vertical, horizontal);
    }

    public int getVerticalDisplacement(){
        return getA();
    }

    public int getHorizontalDisplacement(){
        return getB();
    }

}
