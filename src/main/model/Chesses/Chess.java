package main.model.Chesses;

import static java.lang.Math.abs;
import main.model.Square;
import main.model.Type;
import main.utils.Location;
import main.utils.Side;

public class Chess {
    protected Location location;

    protected Side side;//player: 1 or 2
    public Side getSide(){
        return side;
    }
    public final Animal animal;

    public Chess(Location location, Animal animal, Side owner){
        location = location;
        this.animal = animal;
        this.side=owner;
    }

    @Override
    public String toString() {
        return animal.toString();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * checks whether it is possible to move to an empty
     * overridden in RAT, TIG, LIO
     * @param destination
     * @param square
     * @return
     */
    public boolean canMoveToEmpty(Location original, Location destination, Square square){
        // testing code

        int dx = destination.getRow();
        int dy = destination.getCol();
        int x = original.getRow();
        int y = original.getCol();

        // 这一步应该在磁盘中检查valid location 而不是在这里检查！！
        // 棋子怎么会知道棋盘的属性
//        if(dx<1 || dx>9 || dy<1 || dy>7){
//            return false;
//        }
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
        return false;
    }


    /**
     * This method would be overriden in RAT & ELE
     * @param animal1
     * @return true if it is possible to take a piece
     */
    protected boolean outRank(Animal animal1){
        return animal.getRank()>=animal1.getRank();
    }


    /**
     * checks whether it is possible to take a piece on a square
     *
     * special cases to be handled by chessboard:
     * 1. Capturing a rat in the river from land
     * 2. Rat in river capturing piece on land
     * @param square
     * @return true if it is possible to take a piece on a square
     */
    public boolean canTake(Square square){
        if(square.getChessContent().getSide() == this.side){
            return false;
        }
        switch (square.getType()){
            case NORMAL:
                return outRank(square.getChessContent().getAnimal());
            case RIVER:
                return true;

            case TRAP1:
                if(side == Side.Red){
                    return true;
                }else{
                    return outRank(square.getChessContent().getAnimal());
                }

            case TRAP2:
                if(side == Side.Blue){
                    return true;
                }else{
                    return outRank(square.getChessContent().getAnimal());
                }
        }
        return true;
    }
}
