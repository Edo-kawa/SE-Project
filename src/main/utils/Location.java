package src.main.utils;



/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class Location extends Pair<Integer, Integer>{

    public Location(int row, int column){
        super(row, column);
    }

    public int getRow(){
        return getA();
    }

    public int getCol(){
        return getB();
    }


    /**
     * Construct a location that's left of the current location.
     */
    public Location getLeft() {
        return getIncrement(new Vector(0, -1));
    }

    /**
     * Construct a location that's right of the current location.
     */
    public Location getRight() {
        return getIncrement(new Vector(0, 1));
    }

    /**
     * Construct a location that's above the current location.
     */
    public Location getAbove() {
        return getIncrement(new Vector(-1, 0));
    }

    /**
     * Construct a location that's below the current location.
     */
    public Location getBelow() {
        return getIncrement(new Vector(1, 0));
    }

    /**
     * Get a location in a direction.
     *
     * @param direction The direction of the location.
     */
    public Location getIncrement(Vector direction) {
        return new Location(getRow() + direction.getVerticalDisplacement(),
                getCol() + direction.getHorizontalDisplacement());
    }


}
