package model;

import main.model.Pieces.Piece;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description:
 */
public interface Observable {

    void move(Piece chess, int nextX, int nextY);

    void notifyObservers();
}