package main.model;

import main.model.Pieces.Piece;
import main.utils.*;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static main.model.Type.*;
import static main.model.Type.TRAP2;

public class ChessBoard {

    private final int row = 9;
    private final int column = 7;
    
    private ArrayList<Square> squares = new ArrayList<Square>();

    /**
     * The position (ArrayList index) of a piece
     * -1 if already eaten
     * order: /, player1 [0][1-8], player2 [1][1-8] 1-8 standing for Rank
     */
    private Location[][] position = new Location[2][9];

    private final int PLAYER_1; // 0 for Red-side player
    private final int PLAYER_2; // 1 for Blue-side player

    public ChessBoard(){};

    public Location getPosition(int player, int index);

    /**
     * Check if the location is on the chess board.
     * @param location
     * @return true if the location is valid
     */
    boolean checkValidLocation(Location location);

    /**
     * Check if a move is legal/valid, including capturing.
     * @param from
     * @param to
     * @return true if the moving piece is capable of taking the piece on destination,
     *              or the moving piece is capable of crossing the river when no rat is in the water;
     *         false otherwise
     */
    public boolean checkLegalMove(Location from, Location to);

    /**
     * Assuming the move is valid (it has been checked),
     * move a piece to a position. 
     * And modify the index in location
     * @param from
     * @param to
     */
    public void moveTo(Location from, Location to);

    /**
     * Clear the piece in that location. 
     * @param location
     */
    public void clear(Location location);

    /**
     * Check if there is any winner
     * @return 0 if no winner, 
     *         1 if player_1 wins, 
     *         2 if player_2 wins
     */
    public int checkWinner();

    /**
     * Returns the square on a specific location
     * @param location
     * @return the square on the given location
      */
    public Square getSquare(Location location);

    /**
     * Initializes the ChessBoard
     * Arranges squares and assigns pieces
      */
    public void init();

}
