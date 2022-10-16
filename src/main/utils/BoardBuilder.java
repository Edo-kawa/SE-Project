package main.utils;

import main.model.Chesses.*;

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
                                     Side sideName, int row, int col){

        if(pieceName.equals("ELE")){
            return new Elephant(new Location(col, row), sideName);
        }

        if(pieceName.equals("LIO")){
            return new Lion(new Location(col, row), sideName);
        }
        if(pieceName.equals("TIG")){
            return new Tiger(new Location(col, row), sideName);
        }
        if(pieceName.equals("LEO")){
            return new Leopard(new Location(col, row), sideName);
        }
        if(pieceName.equals("WOL")){
            return new Wolf(new Location(col, row), sideName);
        }
        if(pieceName.equals("DOG")){
            return new Dog(new Location(col, row), sideName);
        }

        if(pieceName.equals("CAT")){
            return new Cat(new Location(col, row), sideName);
        }

        if(pieceName.equals("RAT")){
            return new Rat(new Location(col, row), sideName);
        }

        return null;

    }



}
