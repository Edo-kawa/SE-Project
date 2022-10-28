package utils;

public class Location{

    private final int r,i,c;
    public Location(int row, int column){
        i=(row-1)*7+column-1;
        r=row;
        c=column;
    }
    public int getRow(){
        return r;
    }
    public int getCol(){
        return c;
    }
    public int getIndex(){
        return i;
    }
}
