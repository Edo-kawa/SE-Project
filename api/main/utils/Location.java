package main.utils;

public class Location{

    private int r,i,c;
    public Location(int row, int column){
        i=(row-1)*7+column-1;
        r=row;
        c=column;
    }

    public Location(int index){
        i=index;
        c=index%7+1;
        r=index/7+1;
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
