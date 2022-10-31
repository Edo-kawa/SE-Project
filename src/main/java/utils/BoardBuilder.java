package utils;

import model.Pieces.*;

public class BoardBuilder {
    // Create pieces by String
    public static Piece chessFactory(String pieceName, Side sideName){
        if(pieceName.equals("ELE")){
            return new Elephant(sideName);
        }

        if(pieceName.equals("LIO")){
            return new Lion(sideName);
        }
        if(pieceName.equals("TIG")){
            return new Tiger(sideName);
        }
        if(pieceName.equals("LEO")){
            return new Piece(Animal.LEO, sideName);
        }
        if(pieceName.equals("WOL")){
            return new Piece(Animal.WOL, sideName);
        }
        if(pieceName.equals("DOG")){
            return new Piece(Animal.DOG, sideName);
        }

        if(pieceName.equals("CAT")){
            return new Piece(Animal.CAT, sideName);
        }

        if(pieceName.equals("RAT")){
            return new Rat(sideName);
        }

        return null;
    }
}
