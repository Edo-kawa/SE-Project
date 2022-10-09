package src.main.model.Chesses;

import static java.lang.Math.abs;
import src.main.model.Square;
import src.main.model.Type;

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
     * checks whether it is possible to take a piece
     * (conownerrs only animal type, not the square type or position)
     * overridden in RAT & ELE
     */
    protected boolean outRank(Animal animal1){
        return animal.getRank()>=animal1.getRank();
    }
    /**
     * checks whether it is possible to take a piece on a square
     * (conownerrs only animal and square type, not position)
     * special cases to be handled by chessboard:
     * 1. Capturing a rat in the river from land
     * 2. Rat in river capturing piece on land
     */
    public boolean canTake(Square square){
        if(square.getContent().getOwner()==owner){
            return false;
        }
        switch (square.getType()){
            case NORMAL:
                return outRank(square.getContent().getAnimal());
            case RIVER:
                return true;
            case TRAP1:
                if(owner==1){
                    return true;
                }else{
                    return outRank(square.getContent().getAnimal());
                }
            case TRAP2:
                if(owner==2){
                    return true;
                }else{
                    return outRank(square.getContent().getAnimal());
                }
        }
        return true;
    }
}
