package model;

import model.Pieces.Piece;

import utils.BoardBuilder;
import utils.Location;
import utils.Side;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static model.Type.*;

public class ChessBoard {

    private final ArrayList<Square> squares= new ArrayList<>();


    /**
     * The position (ArrayList index) of a piece
     * -1 if already eaten
     * order: /, player1 [0][1-8], player2 [1][1-8] 1-8 standing for Rank
     */
    
    private final Location[][] position = new Location[2][9];
    private final int PLAYER_1 = 0; // red
    private final int PLAYER_2 = 1; // blue


    public ChessBoard(){}

    public Location getPosition(int player, int index) {

        if(player < 0 || player >1 || index < 1 || index > 8){
            System.out.println(player+"|"+index);
            throw new RuntimeException("Invalid parameters");
        }
        return position[player][index];
    }

    /**
     * Check if the location is on the chess board.
     * @param location the location to be checked
     * @return true if the location is valid
     */
    boolean checkValidLocation(Location location){
        int row = 9;
        int column = 7;
        return location.getRow() >= 1 && location.getRow() <= row
                && location.getCol() >= 1 && location.getCol() <= column;
    }

    /**
     * Check if a move is legal/valid, including capturing.
     * @param from the source
     * @param to the destination
     * @return true is valid, false if invalid
     */
    public boolean checkLegalMove(Location from, Location to){

        // testing code
        System.out.println("From: \t" + from.getRow() + "\t, " + from.getCol());
        System.out.println("To: \t" + to.getRow() + "\t, " + to.getCol());

        if(!checkValidLocation(to)){
            return false;
        }

        if(getSquare(from).getChessContent().canMoveToEmpty(from, to, getSquare(to))){
            if(getSquare(to).getChessContent() != null){
                if(!getSquare(from).getChessContent().canTake(getSquare(to))){
                    return false;
                }

                if(getSquare(from).getType()==Type.RIVER && getSquare(to).getType()!=Type.RIVER){
                    return false;
                }
                if(getSquare(from).getType()!=Type.RIVER && getSquare(to).getType()==Type.RIVER){
                    return false;
                }
            }

            // If rat is in the river
            if(Math.abs(from.getRow()-to.getRow())<=1 && Math.abs(from.getCol()-to.getCol())<=1){
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
                         temp<max(from.getRow(), to.getRow()); temp++) {
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
     * @param from the source
     * @param to the destination
     */
    public void moveTo(Location from, Location to){
        if(squares.get(to.getIndex()).getChessContent()!=null){
            clear(to);
        }
        Piece piece =squares.get(from.getIndex())
                .getChessContent();


        squares.get(to.getIndex()).setContent(piece);
        squares.get(from.getIndex()).setContent(null);
        
        if(piece.getSide() == Side.Red){
            position[PLAYER_1][piece.getAnimal().getRank()] = to;
        }else{
            position[PLAYER_2][piece.getAnimal().getRank()] = to;
        }
    }

    /**
     * Clear the piece in that location. 
     * @param location the location
     */
    public void clear(Location location){
        Piece piece = squares.get(location.getIndex()).getChessContent();
        squares.get(location.getIndex()).setContent(null);

        if(piece.getSide() == Side.Red){
            position[PLAYER_1][piece.getAnimal().getRank()]=null;
        }else{
            position[PLAYER_2][piece.getAnimal().getRank()]=null;
        }
    }

    /**
     * Check if there is any winner
     * @return 0 if no winner, 
     *         1 if player_1 wins, 
     *         2 if player_2 wins
     */
    public int checkWinner(){
        
        if(squares.get(3)
                .getChessContent()!=null){
            return 2;
        }
        if(squares.get(59)
                .getChessContent()!=null){
            return 1;
        }
        
        // check if player_1 has lost all pieces
        boolean flag=true;
        for(int i=1;i<=8;i++){
            if(position[PLAYER_1][i]!=null){
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
            if(position[PLAYER_2][i]!=null){
                flag=false;
                break;
            }
        }
        if(flag){
            return 1;
        }
        
        return 0;
    }

    public Square getSquare(Location location){
        // testing code
        if(checkValidLocation(location)){
            return squares.get(location.getIndex());
        }
        return null;
    }

    public void init(){
        position[PLAYER_1][6]=new Location(1,1);
        squares.add(new Square(BoardBuilder.chessFactory("TIG", Side.Red), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, DEN1));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_1][7]=new Location(1,7);
        squares.add(new Square(BoardBuilder.chessFactory("LIO", Side.Red), NORMAL));

        squares.add(new Square(null, NORMAL));
        position[PLAYER_1][2]=new Location(2,2);
        squares.add(new Square(BoardBuilder.chessFactory("CAT", Side.Red), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_1][3]=new Location(2,6);
        squares.add(new Square(BoardBuilder.chessFactory("DOG", Side.Red), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1][8]=new Location(3,1);
        squares.add(new Square(BoardBuilder.chessFactory("ELE", Side.Red), NORMAL));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_1][4]=new Location(3,3);
        squares.add(new Square(BoardBuilder.chessFactory("WOL", Side.Red), NORMAL));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_1][5]=new Location(3,5);
        squares.add(new Square(BoardBuilder.chessFactory("LEO", Side.Red), NORMAL));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_1][1]=new Location(3,7);
        squares.add(new Square(BoardBuilder.chessFactory("RAT", Side.Red), NORMAL));

        for(int temp=0;temp<3;temp++){
            squares.add(new Square(null, NORMAL));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, NORMAL));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, NORMAL));
        }

        position[PLAYER_2][1]=new Location(7,1);
        squares.add(new Square(BoardBuilder.chessFactory("RAT", Side.Blue), NORMAL));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_2][5]=new Location(7,3);
        squares.add(new Square(BoardBuilder.chessFactory("LEO", Side.Blue), NORMAL));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_2][4]=new Location(7,5);
        squares.add(new Square(BoardBuilder.chessFactory("WOL", Side.Blue), NORMAL));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_2][8]=new Location(7,7);
        squares.add(new Square(BoardBuilder.chessFactory("ELE", Side.Blue), NORMAL));

        squares.add(new Square(null, NORMAL));
        position[PLAYER_2][3]=new Location(8,2);
        squares.add(new Square(BoardBuilder.chessFactory("DOG", Side.Blue), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_2][2]=new Location(8,6);
        squares.add(new Square(BoardBuilder.chessFactory("CAT", Side.Blue), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2][7]=new Location(9,1);
        squares.add(new Square(BoardBuilder.chessFactory("LIO", Side.Blue), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, DEN2));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, NORMAL));
        position[PLAYER_2][6]=new Location(9,7);
        squares.add(new Square(BoardBuilder.chessFactory("TIG", Side.Blue), NORMAL));

    }

}
