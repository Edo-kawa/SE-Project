package src.main.model;


import src.main.model.Chesses.Chess;

public class Square {
    private Chess chess;
    private Type type;

    public Square(Chess chess, Type type) {
        this.chess = chess;
        this.type = type;
    }

    public Square() {
        new Square(null, type.NORMAL);
    }
    public Square(Type type) {

        new Square(null, type);
    }

}
