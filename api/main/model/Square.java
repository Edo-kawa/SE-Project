package main.model;

import main.model.Pieces.Piece;
import main.utils.Side;
import main.view.ConsoleColors;

public class Square{
    private Piece piece;
    private Type type;
    public Piece getChessContent(){
        return piece;
    }
    public void setContent(Piece c){
        piece = c;
    }

    @Override
    /**
     * @return A color block representing a specific type of square
      */
    public String toString();

    public Type getType() { return type; }

    public Square(Piece chess, Type type) {
        this.piece = chess;
        this.type = type;
    }
}
