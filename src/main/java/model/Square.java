package model;

import model.Pieces.*;
import utils.*;
import view.*;

import java.util.Objects;

public class Square{
    private Piece piece;
    private final Type type;
    public Piece getPieceContent(){
        return piece;
    }
    public void setContent(Piece c){
        piece =c;
    }

    /**
     *  toString() function is overridden to represent squares in different colors
     * @return the string for different types of squares to be printed
     */
    @Override
    public String toString() {
        if (piece ==null){
            switch (type){
                case NORMAL:return ConsoleColors.GREEN_BACKGROUND + "   " + ConsoleColors.RESET;
                case RIVER:return ConsoleColors.CYAN_BACKGROUND + "   " + ConsoleColors.RESET;
                case TRAP1:
                case TRAP2:return  ConsoleColors.BLACK_BACKGROUND_BRIGHT + "   " + ConsoleColors.RESET;
                case DEN1:
                case DEN2:return ConsoleColors.BLACK_BACKGROUND + "   " + ConsoleColors.RESET;
            }
        }
        if (piece.getSide() == Side.Red){
            return ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT + piece.toString() + ConsoleColors.RESET;
        }else{
            return ConsoleColors.BLUE_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + piece.toString() + ConsoleColors.RESET;
        }

    }

    public Type getType() {
        return type;
    }

    public Square(Piece chess, Type type) {
        this.piece = chess;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj instanceof Square){
            Square square = (Square) obj;
            return this.piece.equals(square.piece) &&
                    this.type == square.type;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(piece, type);
    }
}
