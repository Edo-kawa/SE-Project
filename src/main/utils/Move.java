package src.main.utils;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class Move extends Pair<Location, Location>{

    private boolean mIsAttack;


    /**
     * Construct a move.
     *
     * @param from The location it moves from
     * @param to   The location it moves to
     */
    public Move(Location from, Location to) {
        super(from, to);
        mIsAttack = false;
    }

    /**
     * Set whether the move is an attack move.
     */
    public void attack() {
        mIsAttack = true;
    }

    /**
     * Check whether the move is an attack move. The attack move must attack a
     * piece.
     */
    public boolean isAttack() {
        return mIsAttack;
    }

    /**
     * Get where the move is from.
     */
    public Location getFrom() {
        return getA();
    }

    /**
     * Get where the move to to.
     */
    public Location getTo() {
        return getB();
    }

    /**
     * Get the direction of this move.
     */
    public Vector getDirection() {
        Location toLocation = getTo();
        Location fromLocation = getFrom();
        return Vector.buildVectorFromLocations(fromLocation, toLocation);
    }
}
