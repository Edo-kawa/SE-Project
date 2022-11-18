package utils;

import model.Pieces.*;

/**
 *  To construct chess pieces from their string/enum representations.
 */
public class BoardBuilder {

    /**
     * Factory methods for producing(initializing) the expected piece
     * from the pieceName and SideName.
     * @param pieceName The name of piece
     * @param sideName  The Side
     * @return the expected initialized piece
     */
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
