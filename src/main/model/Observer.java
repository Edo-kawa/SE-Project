package main.model;


import main.model.Chesses.Chess;
import main.utils.Location;
import main.utils.Move;

/**
 * @Author Anthony Z.
 * @Date 8/10/2022
 * @Description: Observer can subscribe to the change of game
 * status, such as piece movement and removal of piece.
 */
public interface Observer {

    /**
     * Called when a chess has moved board.
     * @param move The move of the chess (from and to location).
     */
    void chessMoved(Move move);

    /**
     * Called when a piece is removed from the bard.
     *
     * @param chessMoved
     * @param originalLocation
     */
    void chessRemoved(Chess chessMoved, Location originalLocation);

}
