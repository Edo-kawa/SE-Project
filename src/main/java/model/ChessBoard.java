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
    private final String[] rank2Name = {null, "RAT", "CAT", "DOG", "WOL", "LEO", "TIG", "LIO", "ELE"};
    private final int[][] defaultLocations = {
        {-1, 20, 8, 12, 16, 18, 0, 6, 14},
        {-1, 42, 54, 50, 46, 44, 62, 56, 48}
    };

    /**
     * The position (ArrayList index) of a piece
     * -1 if already eaten
     * order: player1 [0][1-8], player2 [1][1-8] 1-8 standing for Rank
     */
    private final Location[][] position = new Location[2][9];
    private final int PLAYER_RED_INDEX = Side.Red.getNum() - 1; // red
    private final int PLAYER_BLUE_INDEX = Side.Blue.getNum() - 1; // blue

    private final int minIndex = 1, maxIndex = 8;

    public ChessBoard(){}

    public Location getPosition(int player, int index) {
        if(player < PLAYER_RED_INDEX || player > PLAYER_BLUE_INDEX || index < minIndex || index > maxIndex){
            throw new RuntimeException("Invalid parameters");
        }
        return position[player][index];
    }

    public Location[][] getPositions() {
        return this.position;
    }

    /**
     * Check if a move is legal/valid, including capturing.
     * @param from the source
     * @param to the destination
     * @return true is valid, false if invalid
     */
    public boolean checkLegalMove(Location from, Location to){
        if(getSquare(from).getPieceContent().canMoveToEmpty(from, to, getSquare(to))){
            if(getSquare(to).getPieceContent() != null){
                if(!getSquare(from).getPieceContent().canTake(getSquare(to))){
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

                        if(getSquare(new Location(from.getRow(), temp)).getPieceContent()!=null){
                            rat_in_river=true;
                        }
                    }
                }
                if(from.getCol() == to.getCol()){
                    for (int temp=min(from.getRow(), to.getRow())+1;
                         temp<max(from.getRow(), to.getRow()); temp++) {
                        if(getSquare(new Location(temp, from.getCol())).getPieceContent()!=null){
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
        if(squares.get(to.getIndex()).getPieceContent()!=null){
            clear(to);
        }
        Piece piece =squares.get(from.getIndex()).getPieceContent();

        squares.get(to.getIndex()).setContent(piece);
        squares.get(from.getIndex()).setContent(null);
        
        if(piece.getSide() == Side.Red){
            position[PLAYER_RED_INDEX][piece.getAnimal().getRank()] = to;
        }else{
            position[PLAYER_BLUE_INDEX][piece.getAnimal().getRank()] = to;
        }
    }

    /**
     * Clear the piece in that location. 
     * @param location the location
     */

    private void clear(Location location){
        Piece piece = squares.get(location.getIndex()).getPieceContent();

        squares.get(location.getIndex()).setContent(null);

        if(piece.getSide() == Side.Red){
            position[PLAYER_RED_INDEX][piece.getAnimal().getRank()]=null;
        }else{
            position[PLAYER_BLUE_INDEX][piece.getAnimal().getRank()]=null;
        }
    }

    /**
     * Check if there is any winner
     * @return 0 if no winner, 
     *         1 if player_1 wins, 
     *         2 if player_2 wins
     */
    public int checkWinner(){
        
        if(squares.get(3).getPieceContent()!=null){
            return 2;
        }
        if(squares.get(59).getPieceContent()!=null){
            return 1;
        }
        
        // check if player_1 has lost all pieces
        boolean flag = true;
        for(int i = minIndex; i <= maxIndex; i++){
            if(position[PLAYER_RED_INDEX][i] != null){
                flag=false;
                break;
            }
        }
        if(flag){
            return 2;
        }

        // check if player_2 has lost all pieces
        flag = true;
        for(int i = minIndex; i <= maxIndex; i++){
            if(position[PLAYER_BLUE_INDEX][i] != null){
                flag = false;
                break;
            }
        }
        if(flag){
            return 1;
        }
        
        return 0;
    }

    public Square getSquare(Location location){
        return squares.get(location.getIndex());
    }

    public void setPositionByDefault() {
        for (int i = minIndex; i <= maxIndex; i++) {
            squares.get(defaultLocations[0][i]).setContent(BoardBuilder.chessFactory(rank2Name[i], Side.Red));
            this.position[0][i] = new Location(defaultLocations[0][i]);

            squares.get(defaultLocations[1][i]).setContent(BoardBuilder.chessFactory(rank2Name[i], Side.Blue));
            this.position[1][i] = new Location(defaultLocations[1][i]);
        }
    }

    /**
     * Initialize the ChessBoard with loaded positions or positions by default
     * @param locations the pre-saved locations loded by SaverLoader
     */
    public void init(Location[][] locations) {
        for (int i = 0; i < 63; i++) {
            switch (i) {
                case 3:
                    squares.add(new Square(null, DEN1));
                    break;
                case 59:
                    squares.add(new Square(null, DEN2));
                    break;
                case 22: case 23: case 25: case 26: case 29: case 30:
                case 32: case 33: case 36: case 37: case 39: case 40:
                    squares.add(new Square(null, RIVER));
                    break;
                case 2: case 4: case 10:
                    squares.add(new Square(null, TRAP1));
                    break;
                case 52: case 58: case 60:
                    squares.add(new Square(null, TRAP2));
                    break;
                default:
                    squares.add(new Square(null, NORMAL));
            }
        }

        if (locations == null) {
            setPositionByDefault();
            return;
        }

        Location tempLOC;
        Side tempSN;
        for (int i = PLAYER_RED_INDEX; i <= PLAYER_BLUE_INDEX; i++) {
            tempSN = (i == PLAYER_RED_INDEX)? Side.Red: Side.Blue;
            for (int j = minIndex; j <= maxIndex; j++) {
                tempLOC = locations[i][j];
                if (tempLOC != null) {
                    this.squares.get(locations[i][j].getIndex()).
                            setContent(BoardBuilder.chessFactory(rank2Name[j], tempSN));
                }
                this.position[i][j] = locations[i][j];
            }
        }
    }
}
