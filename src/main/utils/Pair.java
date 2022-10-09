package src.main.utils;

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
}
