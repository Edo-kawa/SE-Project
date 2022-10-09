package src.main.model;


import src.main.model.Chesses.Chess;
import src.main.utils.Side;
import src.main.view.ConsoleColors;

public class Square{
    private Chess chess;
    private Type type;
    public Chess getContent(){
        return chess;
    }
    public void setContent(Chess c){
        chess=c;
    }

    @Override
    public String toString() {
        if (chess==null){
            switch (type){
                case NORMAL:return ConsoleColors.GREEN_BACKGROUND + "   " + ConsoleColors.RESET;
                case RIVER:return ConsoleColors.CYAN_BACKGROUND + "   " + ConsoleColors.RESET;
                case TRAP1:
                case TRAP2:return  ConsoleColors.BLACK_BACKGROUND_BRIGHT + "   " + ConsoleColors.RESET;
                case DEN1:
                case DEN2:return ConsoleColors.BLACK_BACKGROUND + "   " + ConsoleColors.RESET;
            }
        }
        if (chess.getSide() == Side.Red){
            return ConsoleColors.RED_BACKGROUND + chess.toString() + ConsoleColors.RESET;
        }else{
            return ConsoleColors.BLUE_BACKGROUND + chess.toString() + ConsoleColors.RESET;
        }

    }


    public Type getType() {
        return type;
    }

    public Square(Chess chess, Type type) {
        this.chess = chess;
        this.type = type;
    }

}
