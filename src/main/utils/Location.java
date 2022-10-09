package src.main.utils;

import java.util.Vector;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class Location extends Pair<Integer, Integer>{

    public Location(int row, int column){
        super(row, column);
    }

    public int getRow(){
        return getA();
    }

    public int getCol(){
        return getB();
    }




}
