package src.main.model;

import src.main.model.Chesses.Chess;
import src.main.utils.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static src.main.model.Type.*;
import static src.main.model.Type.TRAP2;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description: the name of this class should be modified into ChessBoard
 */
public class BoardBase {

    private int width;
    private int height;
    
    private ArrayList<Square> squares;
    private List<Observer> observers;

    /**
     * The position (ArrayList index) of a piece
     * -1 if already eaten
     * order: /, player1 [0][1-8], player2 [1][1-8]
     */
    
    private int[][] position = new int[2][8];
    final int PLAYER_1 = 0; // red
    final int PLAYER_2 = 1; // blue


    BoardBase(int width, int height) throws RuntimeException{
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
     *
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
     * Check if the location contains a chess.
     * @param location
     * @return true if the location is valid and empty.
     */
    boolean checkIsEmpty(Location location){
        if(checkValidLocation(location)){
            Chess chess = getChess(location);
            return chess == null;
        }
        return false;
    }

    /**
     * Check if a move is legal/valid, including capturing.
     * @param index
     * @param to
     * @return
     */
    boolean checkLegalMove(Location from, Location to){

        if(!checkValidLocation(to)){
            return false;
        }

        if(getSquare(from).getChessContent().canMoveToEmpty(to, getSquare(to))){

            if(getSquare(from).getChessContent() != null){
                if(!getSquare(from).getChessContent().canTake(getSquare(to))){
                    return false;
                }
                if(getSquare(from).getType()==RIVER && getSquare(to).getType()!=RIVER){
                    return false;
                }
                if(getSquare(from).getType()!=RIVER && getSquare(to).getType()==RIVER){
                    return false;
                }
            }

            // If rat is in the river
            Vector vector = Vector.buildVectorFromLocations(from, to);
            if(vector.getHorizontalDisplacement()<=1 && vector.getVerticalDisplacement()<=1){
                return true;
            }else{

                boolean rat_in_river=false;

                if(from.getRow() == to.getRow()){
                    for (int temp=min(from.getCol(), to.getCol())+1;
                         temp<max(from.getCol(), to.getCol()); temp++) {

                        if(getSquare(new Location(from.getRow(), temp)).getChessContent()!=null){
                            rat_in_river=true;
                        }
                    }
                }
                if(from.getCol() == to.getCol()){
                    for (int temp=min(from.getRow(), to.getRow())+1;
                         temp<max(from.getRow(), to.getRow())+1; temp++) {
                        if(getSquare(new Location(temp, from.getCol())).getChessContent()!=null){
                            rat_in_river=true;
                        }
                    }
                }
                return !rat_in_river;
            }

        }
        return false;
    }

    /**
     * Assuming the move is valid (it has been checked),
     * move a piece to a position. 
     * And modify the index in location
     * @param from
     * @param to
     */
    public void moveTo(Location from, Location to){
        if(squares.get(location2index(to)).getChessContent()!=null){
            clear(to);
        }
        Chess piece=squares.get(location2index(from))
                .getChessContent();

        piece.setLocation(to);

        squares.get(location2index(to)).setContent(piece);
        squares.get(location2index(from)).setContent(null);
        
        if(piece.getSide() == Side.Red){
            position[PLAYER_1][piece.getAnimal().getRank()] = location2index(to);
        }else{
            position[PLAYER_2][piece.getAnimal().getRank()] = location2index(to);
        }
    }

    /**
     * Clear the piece in that location. 
     * @param location
     */
    public void clear(Location location){
        Chess piece = squares.get(location2index(location)).getChessContent();
        squares.get(location2index(location)).setContent(null);

        if(piece.getSide() == Side.Red){
            position[PLAYER_1][piece.getAnimal().getRank()]=-1;
        }else{
            position[PLAYER_2][piece.getAnimal().getRank()]=-1;
        }
    }

    /**
     * Check if there is any winner
     * @return 0 if no winner, 
     *         1 if player_1 wins, 
     *         2 if player_2 wins
     */
    public int checkWinner(){
        
        if(squares.get(location2index(new Location(1,4)))
                .getChessContent()!=null){
            return 2;
        }
        if(squares.get(location2index(new Location(9,4)))
                .getChessContent()!=null){
            return 1;
        }
        
        // check if player_1 has lost all pieces
        boolean flag=true;
        for(int i=1;i<=8;i++){
            if(position[PLAYER_1][i]!=-1){
                flag=false;
                break;
            }
        }
        if(flag){
            return 2;
        }

        // check if player_2 has lost all pieces
        flag=true;
        for(int i=1;i<=8;i++){
            if(position[PLAYER_2][i]!=-1){
                flag=false;
                break;
            }
        }
        if(flag){
            return 1;
        }
        
        return 0;
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
                    .getChessContent();
        }
        return null;
    }

    /**
     * Convert location into index
     * @param location
     * @return Square
     */
    public Square getSquare(Location location){
        if(checkValidLocation(location)){
            return squares.get(location2index(location));
        }
        return null;
    }

    public Square getSquare(int index){
        return squares.get(index);
    }

    /**
     * Send players some reminder of the next step
     * @param location
     * @return
     */
    public Set<Move> getLegalMoves(Location location){
        Chess chess = getChess(location);
        if(chess == null){
            return new LinkedHashSet<>();
        }

        return null;
    }

    /**
     * @param location
     * @return the index in arrayList
     * row 9  56    57   ...   62
     * row 8  49    50   ...   55
     *  ...
     * row 1   0     1         6
     *      col 1  col 2 ... col 7
     */
    private int location2index(Location location){
        return (location.getRow()-1)*this.width+ location.getCol()-1;
    }

    private void init(){
        position[PLAYER_1][6]=location2index(new Location(1,1));
//        squares.add(new Square(new Tiger(1,1,Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "TIG", Side.Red, 1, 1), NORMAL));

        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, DEN1));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][7]=location2index(new Location(1,7));
//        squares.add(new Square(new Lion(1,7, Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "LIO", Side.Red, 1, 7), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][2]=location2index(new Location(2,2));
//        squares.add(new Square(new Cat(2,2,Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "CAT", Side.Red, 2, 2), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][3]=location2index(new Location(2,6));
//        squares.add(new Square(new Dog(2,6, Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "DOG", Side.Red, 2, 6), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][8]=location2index(new Location(3,1));
//        squares.add(new Square(new Elephant(3,1,Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "ELE", Side.Red, 3, 1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][4]=location2index(new Location(3,3));
//        squares.add(new Square(new Wolf(3,3,Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "WOL", Side.Red, 3, 3), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][5]=location2index(new Location(3,5));
//        squares.add(new Square(new Leopard(3,5,Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "LEO", Side.Red, 3, 5), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][1]=location2index(new Location(3,7));
//        squares.add(new Square(new Rat(3,7,Side.Red), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "RAT", Side.Red, 3, 7), NORMAL));

        for(int temp=0;temp<3;temp++){

            squares.add(new Square(null, NORMAL));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, NORMAL));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, NORMAL));
        }

        position[PLAYER_2][1]=location2index(new Location(7,1));

//        squares.add(new Square(new Rat(7,1,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "RAT", Side.Blue, 7, 1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][5]=location2index(new Location(7,3));
//        squares.add(new Square(new Leopard(7,3,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "LEO", Side.Blue, 7, 3), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][4]=location2index(new Location(7,5));
//        squares.add(new Square(new Wolf(7,5,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "WOL", Side.Blue, 7, 5), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][8]=location2index(new Location(7,7));
//        squares.add(new Square(new Elephant(7,7,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "ELE", Side.Blue, 7, 7), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][3]=location2index(new Location(8,2));
//        squares.add(new Square(new Dog(8,2,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "DOG", Side.Blue, 8, 2), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][2]=location2index(new Location(8,6));
//        squares.add(new Square(new Cat(8,6, Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "CAT", Side.Blue, 8, 6), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][7]=location2index(new Location(9,1));
//        squares.add(new Square(new Lion(9,1,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "LIO", Side.Blue, 9, 1), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, DEN2));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][6]=location2index(new Location(9,7));
//        squares.add(new Square(new Tiger(9,7,Side.Blue), NORMAL));
        squares.add(new Square(BoardBuilder.chessFactory(
                "TIG", Side.Blue, 9, 7), NORMAL));
    }

}
