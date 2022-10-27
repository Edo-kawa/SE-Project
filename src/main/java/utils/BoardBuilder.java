package utils;

import model.Pieces.*;

public class BoardBuilder {

    public static Piece chessFactory(String pieceName,
                                     Side sideName, int row, int col){

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
            return new Piece(new Location(row, col), Animal.LEO, sideName);
        }
        if(pieceName.equals("WOL")){
            return new Piece(new Location(row, col), Animal.WOL, sideName);
        }
        if(pieceName.equals("DOG")){
            return new Piece(new Location(row, col), Animal.DOG, sideName);
        }

        if(pieceName.equals("CAT")){
            return new Piece(new Location(row, col), Animal.CAT, sideName);
        }

        if(pieceName.equals("RAT")){
            return new Rat(new Location(row, col), sideName);
        }

        return null;

    }

}
