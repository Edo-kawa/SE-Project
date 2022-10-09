package src.main.utils;

/**
 * @Author Anthony Z.
 * @Date 9/10/2022
 * @Description: Enum which denotes the side of chess.
 */
public enum Side {
    White, Black;
    public Side next(){
        return Side.values()[(ordinal() + 1) % Side.values().length];
    }
}