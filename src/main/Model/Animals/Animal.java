package main.Model.Animals;

public class Animal {
    public static final int RAT = 1;
    public static final int CAT = 2;
    public static final int DOG = 3;
    public static final int WOL = 4;
    public static final int LEO = 5;
    public static final int TIG = 6;
    public static final int LIO = 7;
    public static final int ELE = 8;

    int rank;

    void move() {}
}

class Rat extends Animal {
    public Rat() {
        this.rank = RAT;
    }
}
