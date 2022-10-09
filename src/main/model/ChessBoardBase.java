package src.main.model;

import src.main.model.Chesses.Chess;
import src.main.utils.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class ChessBoardBase {

    private int width;
    private int height;

    private List<Observer> observers;


    ChessBoardBase(int height, int width) throws RuntimeException{
        if(width<0 || height<0){
            throw new RuntimeException("Invalid size for chess board");
        }
        this.height = height;
        this.width = width;
        observers = new ArrayList<>();

    }


    boolean checkValidLocation(Location location){
        return location.getRow() >= 0 && location.getRow() < width
                && location.getCol() >= 0 && location.getCol() <height;

    }

    boolean checkCanCapture(Location location, Chess chess){

    }



}
