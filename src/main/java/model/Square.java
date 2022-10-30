package model;

import model.Pieces.*;
import utils.*;
import view.*;

public class Square{
    private Piece piece;
    private final Type type;
    public Piece getChessContent(){
        return piece;
    }
    public void setContent(Piece c){
        piece =c;
    }

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
            return ConsoleColors.RED_BACKGROUND + piece.toString() + ConsoleColors.RESET;
        }else{
            return ConsoleColors.BLUE_BACKGROUND + piece.toString() + ConsoleColors.RESET;
        }

    }


    public Type getType() {
        return type;
    }

    public Square(Piece chess, Type type) {
        this.piece = chess;
        this.type = type;
    }

}
