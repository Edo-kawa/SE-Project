package src.main.model.Chesses;

import src.main.utils.Location;
import src.main.utils.Side;

import static java.lang.Math.abs;
import src.main.model.Square;
import src.main.model.Type;

public class Chess {
    private Location location;

    private int owner;//player: 1 or 2

//    private Side side;
//    public Side getSide(){
//        return side;
//
//    }
    public final Animal animal;

    public Chess(int x, int y, Animal animal, Side side){
        this.location = new Location(x, y);
        this.animal = animal;
//        this.side = side;
    }

    @Override
    public String toString() {
        return animal.toString();
    }

    public Animal getAnimal() {
        return animal;
    }


//    public void setX(int x) {
//        this.location
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }

    /**
     * checks whether it is possible to move to an empty
     * overridden in RAT, TIG, LIO
     */
    public boolean canMoveToEmpty(int dx, int dy, Square square){
        if(dx<1 || dx>9 || dy<1 || dy>7){
            return false;
        }
        if(square.getType()== Type.RIVER){
            return false;
        }
        if(square.getType()==Type.DEN1 && owner==1){
            return false;
        }
        if(square.getType()==Type.DEN2 && owner==2){
            return false;
        }
        if(dx==location.getRow() && abs(dy-location.getCol())==1){
            return true;
        }
        if(dy==location.getCol() && abs(dx-location.getRow())==1){
            return true;
        }
        return false;
    }

    /**
     * checks whether it is possible to take a piece on a square
     * (considers only animal and square type, not position)
     */
    public void canTake(Square square){

    }

}
