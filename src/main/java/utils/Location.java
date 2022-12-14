package utils;

import java.util.Objects;

public class Location{

    private final int r,i,c;
    public Location(int row, int column){
        if(row < 1 || row > 9 || column < 1 || column > 7){
            throw new RuntimeException("Illegal access");
        }
        i = (row - 1) * 7 + column - 1;
        r = row;
        c = column;
    }
    public Location(int index) {
        if (index < 0 || index > 62) throw new RuntimeException("Illegal access");
        i = index;
        r = index / 7 + 1;
        c = index - (r - 1) * 7 + 1;
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

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj instanceof Location){
            Location location = (Location) obj;
            return this.i == location.i;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
