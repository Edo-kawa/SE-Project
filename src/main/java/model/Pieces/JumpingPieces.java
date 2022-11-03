package model.Pieces;

import model.*;
import model.Square;
import utils.*;

import static java.lang.Math.abs;
public abstract class JumpingPieces extends Piece {
    public JumpingPieces(Animal animal, Side side){
        super(animal,side);
    }

    public boolean canMoveToEmpty(Location from, Location to, Square square){
        int dx = to.getRow();
        int dy = to.getCol();
        int x = from.getRow();
        int y = from.getCol();

        if(square.getType()== Type.RIVER){
            return false;
        }
        if(square.getType()==Type.DEN1 && side == Side.Red){
            return false;
        }
        if(square.getType()==Type.DEN2 && side == Side.Blue){
            return false;
        }
        if(dx==x && abs(dy-y)==1){
            return true;
        }
        if(dy==y && abs(dx-x)==1){
            return true;
        }

        /*
         Jump over the river
         Special case to be checked by Chessboard: rat in the river
         */
        if(x>=4 && x<=6 && dx==x && abs(dy-y)==3){
            return true;
        }
        return (x == 3 || x == 7) && (y == 2 || y == 3 || y == 5 || y == 6) && y == dy && abs(x - dx) == 4;
    }
}
