package utils;
public enum Side {
    Red(1), Blue(2);
    private final int num;
    Side(int num){
        this.num=num;
    }
    public int getNum() {
        return num;
    }
}