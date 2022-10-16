package src.main.utils;

import src.main.model.Chesses.*;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class BoardBuilder {

//    public static ChessBoard boardFactory(String boardName, int height,
//                                          int width){
//
//        if(boardName.equals("ChessBoard")){
//            return new ChessBoard(width, height);
//
//        }
//
//        return null;
//    }

    public static Chess chessFactory(String pieceName,
                                     Side sideName, int x, int y){

        if(pieceName.equals("ELE")){
            return new Elephant(new Location(x, y),sideName);
        }

        if(pieceName.equals("LIO")){
            return new Lion(new Location(x, y), sideName);
        }
        if(pieceName.equals("TIG")){
            return new Tiger(new Location(x, y), sideName);
        }
        if(pieceName.equals("LEO")){
            return new Leopard(new Location(x, y), sideName);
        }
        if(pieceName.equals("WOL")){
            return new Wolf(new Location(x, y), sideName);
        }
        if(pieceName.equals("DOG")){
            return new Dog(new Location(x, y), sideName);
        }

        if(pieceName.equals("CAT")){
            return new Cat(new Location(x, y), sideName);
        }

        if(pieceName.equals("RAT")){
            return new Rat(new Location(x, y), sideName);
        }

        return null;

    }



}
