package main.utils;

import main.model.Chesses.*;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class BoardBuilder {

    public static Chess chessFactory(String pieceName, Side sideName, int row, int col){

        if(pieceName.equals("ELE")){
            return new Elephant(new Location(row, col), sideName);
        }

        if(pieceName.equals("LIO")){
            return new Lion(new Location(row, col), sideName);
        }
        if(pieceName.equals("TIG")){
            return new Tiger(new Location(row, col), sideName);
        }
        if(pieceName.equals("LEO")){
            return new Leopard(new Location(row, col), sideName);
        }
        if(pieceName.equals("WOL")){
            return new Wolf(new Location(row, col), sideName);
        }
        if(pieceName.equals("DOG")){
            return new Dog(new Location(row, col), sideName);
        }

        if(pieceName.equals("CAT")){
            return new Cat(new Location(row, col), sideName);
        }

        if(pieceName.equals("RAT")){
            return new Rat(new Location(row, col), sideName);
        }

        return null;

    }
}
