package src.main.model;

import src.main.model.Chesses.*;
import src.main.utils.BoardBuilder;
import src.main.utils.Location;
import src.main.utils.Side;


import java.util.ArrayList;

import static java.lang.Math.*;
import static src.main.model.Type.*;

public class BoardStandard {
    final int ROW = 9;
    final int COL = 7;
    private BoardBase standardChessBoard;
//    final int PLAYER_1 = 0;
//    final int PLAYER_2 = 8;
//
//    private ArrayList<Square> squares;

//    public Square getSquare(int x, int y){
//        return squares.get(coordinate2index(x,y));
//    }
//
//    public Square getSquare(int index){
//        return squares.get(index);
//    }

    /**
     * The position (ArrayList index) of a piece
     * -1 if already eaten
     * order: /, player1 1-8, player2 1-8
     */
//    private int[] position=new int[2*8+1];
//
//    public int getPosition(int x){
//        return position[x];
//    }
    public BoardStandard() {
        standardChessBoard = new BoardBase(ROW, COL);
    }
//
//    /**
//     * @return the index in arrayList
//     * row 9  56    57   ...   62
//     * row 8  49    50   ...   55
//     * ...
//     * row 1   0     1         6
//     *       col 1 col 2 ... col 7
//     */
//    public int coordinate2index(int row, int column){
//        return (row-1)*7+column-1;
//    }
//
//    /**
//     * checks whether a move is valid
//     * including capturing
//     */
//    public boolean canMove(int index, int dx, int dy){
//
//        if (getSquare(index).getChessContent().canMoveToEmpty(dx,dy,getSquare(dx,dy))){
//            if(getSquare(dx,dy).getChessContent()!=null){
//                if(!getSquare(index).getChessContent().canTake(getSquare(dx,dy))){
//                    return false;
//                }
//                if(getSquare(index).getType()==RIVER && getSquare(dx,dy).getType()!=RIVER){
//                    return false;
//                }
//                if(getSquare(index).getType()!=RIVER && getSquare(dx,dy).getType()==RIVER){
//                    return false;
//                }
//            }
//            int x0=index/7+1, y0=index%7+1;
//            if(abs(dx-x0)<=1 && abs(dy-y0)<=1){
//                return true;
//            }else{
//                boolean rat_in_river=false;
//                if(x0==dx){
//                    for (int temp=min(y0,dy)+1; temp<max(y0,dy); temp++) {
//                        if(getSquare(x0,temp).getChessContent()!=null){
//                            rat_in_river=true;
//                        }
//                    }
//                }
//                if(y0==dy){
//                    for (int temp=min(x0,dx)+1; temp<max(x0,dx); temp++) {
//                        if(getSquare(temp,y0).getChessContent()!=null){
//                            rat_in_river=true;
//                        }
//                    }
//                }
//                return !rat_in_river;
//            }
//        }
//        return false;
//    }
//    /**
//     * move a piece to a position
//     * assuming validity is checked
//     * origin and destination --> ArrayList index
//     */
//    public void moveTo(int from, int to){
//        if(squares.get(to).getChessContent()!=null){
//            clear(to);
//        }
//        Chess piece=squares.get(from).getChessContent();
////        test code
////        System.out.println("to:" + to);
////        System.out.println(to/7+1);
////        System.out.println(to%7+1);
//        piece.setLocation(new Location(to/7+1, to%7+1));
//
//
//        squares.get(to).setContent(piece);
//        squares.get(from).setContent(null);
//
//        if(piece.getSide() == Side.Red){
//            position[PLAYER_1+piece.getAnimal().getRank()] = to;
//        }else{
//            position[PLAYER_2+piece.getAnimal().getRank()] = to;
//        }
//
//    }
//
//    public void clear(int sq){
//        Chess piece=squares.get(sq).getChessContent();
//        squares.get(sq).setContent(null);
//
//        if(piece.getSide() == Side.Red){
//            position[PLAYER_1+piece.getAnimal().getRank()]=-1;
//        }else{
//            position[PLAYER_2+piece.getAnimal().getRank()]=-1;
//        }
//
//    }

    public void printChessBoard(){
        System.out.println("----------------------------");
        for(int r=9; r>=1; r--){
            System.out.print(" "+r+" - ");
            for(int c=1; c<=7; c++){
                System.out.print(standardChessBoard.getSquare(new Location(r, c)));
            }
            System.out.println();
        }
        System.out.println("      |  |  |  |  |  |  | ");
        System.out.println("      1  2  3  4  5  6  7 ");
        System.out.println("----------------------------");
    }


//    public int checkWinner(){
//        /**
//         * returns 0 if no winner
//         * 1 if player 1 wins
//         * 2 if player 2 wins
//         */
//        if(squares.get(coordinate2index(1,4)).getChessContent()!=null){
//            return 2;
//        }
//        if(squares.get(coordinate2index(9,4)).getChessContent()!=null){
//            return 1;
//        }
//        boolean flag=true;
//        for(int i=1;i<=8;i++){
//            if(position[i]!=-1){
//                flag=false;
//                break;
//            }
//        }
//        if(flag){
//            return 2;
//        }
//        flag=true;
//        for(int i=9;i<=16;i++){
//            if(position[i]!=-1){
//                flag=false;
//                break;
//            }
//        }
//        if(flag){
//            return 1;
//        }
//        return 0;
//    }
//    private void init(){
//        position[PLAYER_1 + 6]=coordinate2index(1,1);
////        squares.add(new Square(new Tiger(1,1,Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "TIG", Side.Red, 1, 1), NORMAL));
//
//        squares.add(new Square(null, NORMAL));
//        squares.add(new Square(null, TRAP1));
//        squares.add(new Square(null, DEN1));
//        squares.add(new Square(null, TRAP1));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 7]=coordinate2index(1,7);
////        squares.add(new Square(new Lion(1,7, Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "LIO", Side.Red, 1, 7), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 2]=coordinate2index(2,2);
////        squares.add(new Square(new Cat(2,2,Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "CAT", Side.Red, 2, 2), NORMAL));
//        squares.add(new Square(null, NORMAL));
//        squares.add(new Square(null, TRAP1));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 3]=coordinate2index(2,6);
////        squares.add(new Square(new Dog(2,6, Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "DOG", Side.Red, 2, 6), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 8]=coordinate2index(3,1);
////        squares.add(new Square(new Elephant(3,1,Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "ELE", Side.Red, 3, 1), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 4]=coordinate2index(3,3);
////        squares.add(new Square(new Wolf(3,3,Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "WOL", Side.Red, 3, 3), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 5]=coordinate2index(3,5);
////        squares.add(new Square(new Leopard(3,5,Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "LEO", Side.Red, 3, 5), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_1 + 1]=coordinate2index(3,7);
////        squares.add(new Square(new Rat(3,7,Side.Red), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "RAT", Side.Red, 3, 7), NORMAL));
//
//        for(int temp=0;temp<3;temp++){
//
//            squares.add(new Square(null, NORMAL));
//            squares.add(new Square(null, RIVER));
//            squares.add(new Square(null, RIVER));
//            squares.add(new Square(null, NORMAL));
//            squares.add(new Square(null, RIVER));
//            squares.add(new Square(null, RIVER));
//            squares.add(new Square(null, NORMAL));
//        }
//
//        position[PLAYER_2 + 1]=coordinate2index(7,1);
//
////        squares.add(new Square(new Rat(7,1,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "RAT", Side.Blue, 7, 1), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 5]=coordinate2index(7,3);
////        squares.add(new Square(new Leopard(7,3,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "LEO", Side.Blue, 7, 3), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 4]=coordinate2index(7,5);
////        squares.add(new Square(new Wolf(7,5,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "WOL", Side.Blue, 7, 5), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 8]=coordinate2index(7,7);
////        squares.add(new Square(new Elephant(7,7,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "ELE", Side.Blue, 7, 7), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 3]=coordinate2index(8,2);
////        squares.add(new Square(new Dog(8,2,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "DOG", Side.Blue, 8, 2), NORMAL));
//        squares.add(new Square(null, NORMAL));
//        squares.add(new Square(null, TRAP2));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 2]=coordinate2index(8,6);
////        squares.add(new Square(new Cat(8,6, Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "CAT", Side.Blue, 8, 6), NORMAL));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 7]=coordinate2index(9,1);
////        squares.add(new Square(new Lion(9,1,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "LIO", Side.Blue, 9, 1), NORMAL));
//        squares.add(new Square(null, NORMAL));
//        squares.add(new Square(null, TRAP2));
//        squares.add(new Square(null, DEN2));
//        squares.add(new Square(null, TRAP2));
//        squares.add(new Square(null, NORMAL));
//
//        position[PLAYER_2 + 6]=coordinate2index(9,7);
////        squares.add(new Square(new Tiger(9,7,Side.Blue), NORMAL));
//        squares.add(new Square(BoardBuilder.chessFactory(
//                "TIG", Side.Blue, 9, 7), NORMAL));
//    }

//}
