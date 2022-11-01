package model;

import model.Pieces.Animal;
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
    private final int PLAYER_1 = 0; // red
    private final int PLAYER_2 = 1; // blue

    public ChessBoard(){}

    public Location getPosition(int player, int index) {
        if(player < 0 || player >1 || index < 1 || index > 8){
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
        Piece piece =squares.get(from.getIndex()).getChessContent();

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
        
        if(squares.get(3).getChessContent()!=null){
            return 2;
        }
        if(squares.get(59).getChessContent()!=null){
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
        return squares.get(location.getIndex());
    }

    public void setPositionByDefault() {
        for (int i = 1; i < 9; i++) {
            squares.get(defaultLocations[0][i]).setContent(BoardBuilder.chessFactory(rank2Name[i], Side.Red));
            this.position[0][i] = Location.parseIndex(defaultLocations[0][i]);

            squares.get(defaultLocations[1][i]).setContent(BoardBuilder.chessFactory(rank2Name[i], Side.Blue));
            this.position[1][i] = Location.parseIndex(defaultLocations[1][i]);
        }
    }

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
        for (int i = 0; i < 2; i++) {
            tempSN = (i == 0)? Side.Red: Side.Blue;
            for (int j = 0; j < 9; j++) {
                tempLOC = locations[i][j];
                if (tempLOC != null) {
                    this.squares.get(locations[i][j].getIndex()).
                            setContent(BoardBuilder.chessFactory(rank2Name[j], tempSN));
                }
                this.position[i][j] = locations[i][j];
            }
        }
    }

    /*public void init(){
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

    }*/

}
