package src.main.model.Chesses;

public enum Animal {
    RAT(1), CAT(2), DOG(3), WOL(4),
    LEO(5), TIG(6), LIO(7), ELE(8);

    private int rank;
    private Animal(int rank){
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return Integer.toString(getRank());
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

