package src.main.model;

import src.main.model.Chesses.Chess;
import src.main.utils.Location;
import src.main.utils.Move;

/**
 * @Author Anthony Z.
 * @Date 15/10/2022
 * @Description: Listen for game state change
 */
public class Command implements Observer{


    private BoardBase chessBoard;

    /**
     * If the chess has moved, track it.
     * @param move The move of the chess (from and to location).
     */
    @Override
    public void chessMoved(Move move) {
        Chess moveTo;
    }

    @Override
    public void chessRemoved(Chess chessMoved, Location originalLocation) {

    }
}
