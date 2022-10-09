package src.main.model.Chesses;

import static java.lang.Math.abs;
import src.main.model.Square;
import src.main.model.Type;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public abstract class Chess {
    protected int x;
    protected int y;

    protected int owner;//player: 1 or 2
    public int getOwner(){
        return owner;
    }
    public final Animal animal;

    public Chess(int x, int y, Animal animal, int owner){
        this.x = x;
        this.y = y;
        this.animal = animal;
        this.owner=owner;
    }

    @Override
    public String toString() {
        return animal.toString();
    }

    public Animal getAnimal() {
        return animal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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
        if(dx==x && abs(dy-y)==1){
            return true;
        }
        if(dy==y && abs(dx-x)==1){
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
