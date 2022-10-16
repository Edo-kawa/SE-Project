package main.utils;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description:
 */
public class Pair<A, B>{
    private A mA;
    private B mB;

    public Pair(A a, B b){
        this.mA = a;
        this.mB = b;
    }


    public A getA() {
        return mA;
    }

    public void setA(A mA) {
        this.mA = mA;
    }

    public B getB() {
        return mB;
    }

    public void setB(B mB) {
        this.mB = mB;
    }

    /**
     * Compute the hash code using the two elements.
     */
    @Override
    public int hashCode() {
        return 13 * mA.hashCode() + 37 * mB.hashCode();
    }

    /**
     * Check whether two pairs are the same. They are the same iff the two
     * elements equal to the corresponding ones of the other object.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked") Pair<A, B> other = (Pair<A, B>) o;
        return other.mA.equals(mA) && other.mB.equals(mB);
    }

    /**
     * String representation of the element. It has the format: "(A_str, B_str)".
     */
    @Override
    public String toString() {
        return "(" + mA.toString() + ", " + mB.toString() + ")";
    }
}
