package main.model.Chesses;

public enum Animal {
    RAT(1), CAT(2), DOG(3), WOL(4),
    LEO(5), TIG(6), LIO(7), ELE(8);

    private int rank;
    Animal(int rank){
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

}

