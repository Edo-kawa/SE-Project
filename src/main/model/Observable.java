package main.model;

import main.model.Chesses.Chess;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description:
 */
public interface Observable {

    void move(Chess chess, int nextX, int nextY);

    void notifyObservers();
}