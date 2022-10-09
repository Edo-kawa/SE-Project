package src.main.model;

import src.main.model.Chesses.*;


import java.util.ArrayList;

import static src.main.model.Type.*;

public class ChessBoard implements Observer{
    final int ROW = 9;
    final int COL = 7;
    final int PLAYER_1 = 0;
    final int PLAYER_2 = 8;

    private ArrayList<Square> squares;

    public Square getSquare(int x, int y){
        return squares.get(coordinate2index(x,y));
    }

    public  Square getSquare(int x){
        return squares.get(x);
    }

    /**
     * The position (ArrayList index) of a piece
     * -1 if already eaten
     * order: /, player1 1-8, player2 1-8
     */
    private int[] position=new int[2*8+1];

    public int getPosition(int x){
        return position[x];
    }
    public ChessBoard() {
        squares = new ArrayList<>(ROW*COL);
        init();
    }

    /**
     * @return the index in arrayList
     * row 9  56    57   ...   62
     * row 8  49    50   ...   55
     * ...
     * row 1   0     1         6
     *       col 1 col 2 ... col 7
     */
    public int coordinate2index(int row, int column){
        return (row-1)*7+column-1;
    }

    /**
     * move a piece to a position
     * assuming validity is checked
     * origin and destination --> ArrayList index
     */
    public void moveTo(int origin, int destination){
        if(squares.get(destination).getContent()!=null){
            clear(destination);
        }
        Chess piece=squares.get(origin).getContent();
        piece.setX(destination/7+1);
        piece.setY(destination%7+1);
        squares.get(destination).setContent(piece);
        squares.get(origin).setContent(null);
        position[(piece.getOwner()-1)*8+piece.getAnimal().getRank()]=destination;
    }

    public void clear(int sq){
        Chess piece=squares.get(sq).getContent();
        squares.get(sq).setContent(null);
        position[(piece.getOwner()-1)*8+piece.getAnimal().getRank()]=-1;
    }
    private void init(){
        position[PLAYER_1 + 6]=coordinate2index(1,1);
        squares.add(new Square(new Tiger(1,1,1), NORMAL));

        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, DEN1));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 7]=coordinate2index(1,7);
        squares.add(new Square(new Lion(1,7,1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 2]=coordinate2index(2,2);
        squares.add(new Square(new Cat(2,2,1), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP1));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 3]=coordinate2index(2,6);
        squares.add(new Square(new Dog(2,6, 1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 8]=coordinate2index(3,1);
        squares.add(new Square(new Elephant(3,1,1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 4]=coordinate2index(3,3);
        squares.add(new Square(new Wolf(3,3,1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 5]=coordinate2index(3,5);
        squares.add(new Square(new Leopard(3,5,1), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_1 + 1]=coordinate2index(3,7);
        squares.add(new Square(new Rat(3,7,1), NORMAL));

        for(int temp=0;temp<3;temp++){

            squares.add(new Square(null, NORMAL));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, NORMAL));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, RIVER));
            squares.add(new Square(null, NORMAL));
        }

        position[PLAYER_2 + 1]=coordinate2index(7,1);

        squares.add(new Square(new Rat(7,1,2), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2 + 5]=coordinate2index(7,3);
        squares.add(new Square(new Leopard(7,3,2), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2 + 4]=coordinate2index(7,5);
        squares.add(new Square(new Wolf(7,5,2), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2 + 8]=coordinate2index(7,7);
        squares.add(new Square(new Elephant(7,7,2), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2 + 3]=coordinate2index(8,2);
        squares.add(new Square(new Dog(8,2,2), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2 + 2]=coordinate2index(8,6);
        squares.add(new Square(new Cat(8,6, 2), NORMAL));
        squares.add(new Square(null, NORMAL));

        position[PLAYER_2 + 7]=coordinate2index(9,1);
        squares.add(new Square(new Lion(9,1,2), NORMAL));
        squares.add(new Square(null, NORMAL));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, DEN2));
        squares.add(new Square(null, TRAP2));
        squares.add(new Square(null, NORMAL));
        
        position[PLAYER_2 + 6]=coordinate2index(9,7);
        squares.add(new Square(new Tiger(9,7,2), NORMAL));
    }

    @Override
    public void refreshData(Observable subject) {

    }
}
