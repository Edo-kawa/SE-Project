package src.main.model;


import src.main.model.Chesses.Chess;
import src.main.view.ConsoleColors;

public class Square {
    private Chess chess;
    public Chess getContent(){
        return chess;
    }

    @Override
    public String toString() {
        if (chess==null){
            switch (type){
                case NORMAL:return ConsoleColors.GREEN_BACKGROUND + " " + ConsoleColors.RESET;
                case RIVER:return ConsoleColors.CYAN_BACKGROUND + " " + ConsoleColors.RESET;
                case TRAP1:
                case TRAP2:return  ConsoleColors.BLACK_BACKGROUND_BRIGHT + " " + ConsoleColors.RESET;
                case DEN1:
                case DEN2:return ConsoleColors.BLACK_BACKGROUND + " " + ConsoleColors.RESET;
            }
        }
        if (chess.getOwner()==1){
            return ConsoleColors.RED_BACKGROUND + chess.toString() + ConsoleColors.RESET;
        }else{
            return ConsoleColors.BLUE_BACKGROUND + chess.toString() + ConsoleColors.RESET;
        }

    }

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
