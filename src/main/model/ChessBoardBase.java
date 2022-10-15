package src.main.model;

import src.main.model.Chesses.Chess;
import src.main.utils.BoardBuilder;
import src.main.utils.Location;
import src.main.utils.Move;
import src.main.utils.Side;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static src.main.model.Type.NORMAL;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description: the name of this class should be modified into ChessBoard
 */
public class ChessBoardBase {

    private int width;
    private int height;

    private ArrayList<Square> squares;
    private List<Observer> observers;


    ChessBoardBase(int width, int height) throws RuntimeException{
        if(width<0 || height<0){
            throw new RuntimeException("Invalid size for chess board");
        }
        this.width = width;
        this.height = height;

        squares = new ArrayList<>(this.width*this.height);
        observers = new ArrayList<>();

    }


    /**
     * Check if the location is on the chess board.
     * @param location
     * @return true if the location is valid
     */
    boolean checkValidLocation(Location location){
        return location.getRow() >= 0 && location.getRow() < width
                && location.getCol() >= 0 && location.getCol() <height;

    }

    /**
     * Check if the location can be captured by the chess.
     * The condition is ...
     *
     * @param location
     * @param chess
     * @return
     */
    boolean checkCanCapture(Chess chess, Location location){
        Chess target = getChess(location);
        if(target != null && (getChess(location).getSide() != chess.getSide())){

        }
        return false;
    }

    /**
     * Add a chess to the board.
     * It will overwrite the existing chess in that location if any.
     * @param chess
     * @param location
     * @return true if success, false otherwise.
     */
    public boolean setChess(Chess chess, Location location){
        if(checkValidLocation(location)){
            squares.add(new Square(BoardBuilder.chessFactory(
                    "LEO", Side.Red, 3, 5), NORMAL));
            chess.setLocation(location);
            return true;
        }
        return false;
    }

    /**
     * Get the piece in that location
     * @param location
     * @return
     */
    public Chess getChess(Location location){
        if(checkValidLocation(location)){
            return squares.get(location2index(location))
                    .getContent();
        }
        return null;
    }

    public Set<Move> getLegalMoves(Location location){
        Chess chess = getChess(location);
        if(chess == null){
            return new LinkedHashSet<>();
        }
        

    }
    /**
     *
     * @param location
     * @return the index in arrayList
     */
    public int location2index(Location location){
        return (location.getRow()-1)*this.width+ location.getCol()-1;
    }



}
