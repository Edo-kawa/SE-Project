package src.main.view;

import src.main.model.ChessBoard;
import src.main.model.Chesses.Chess;
import src.main.model.Observer;

import java.util.Scanner;

import static java.lang.Math.*;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class ChessBoardView{

    public ChessBoardView(){
        init();
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        ChessBoard chessboard = new ChessBoard();
        //1 or 2
        int player_turn=1;

        while(checkWinner()==0) {
            ChessBoardView.printChessBoard(chessboard);

            if(player_turn==1) {
                System.out.println(ConsoleColors.RED + "Player 1's turn." + ConsoleColors.RESET);
            }else{
                System.out.println(ConsoleColors.BLUE + "Player 2's turn." + ConsoleColors.RESET);
            }
            int index=0;
            boolean flag=true;
            while(flag) {
                System.out.println("Which piece would you like to move?");
                String s = scanner.nextLine();
                if(s.length()<3){
                    continue;
                }
                switch (s.toLowerCase().substring(0, 3)) {
                    case "rat":
                        index = chessboard.getPosition(1 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "cat":
                        index = chessboard.getPosition(2 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "dog":
                        index = chessboard.getPosition(3 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "wol":
                        index = chessboard.getPosition(4 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "leo":
                        index = chessboard.getPosition(5 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "tig":
                        index = chessboard.getPosition(6 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "lio":
                        index = chessboard.getPosition(7 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                    case "ele":
                        index = chessboard.getPosition(8 + 8 * (player_turn - 1));
                        flag=false;
                        break;
                }
                if(index == -1){
                    flag=true;
                }
            }
            flag=true;
            int dx = 0, dy = 0;
            while(flag){
                System.out.println("Please enter destination:");
                String  input = scanner.nextLine();
                if(input.length()!=3){
                    continue;
                }
                if(input.charAt(1) != ' ' && input.charAt(1) != ','){
                    continue;
                }
                dx = input.charAt(0)-'0';
                dy = input.charAt(2)-'0';
                if(dx<1 || dx>9 || dy<1 || dy>7){
                    continue;
                }
                flag=false;
            }

            if (chessboard.getSquare(index).getContent().canMoveToEmpty(dx,dy,chessboard.getSquare(dx,dy))){
                int x0=index/7+1, y0=index%7+1;
                if(abs(dx-x0)<=1 && abs(dy-y0)<=1){
                    chessboard.moveTo(index,chessboard.coordinate2index(dx,dy));
                }else{
                    //jump
                    boolean rat_in_river=false;
                    if(x0==dx){
                        for (int temp=min(y0,dy)+1; temp<max(y0,dy); temp++) {
                            if(chessboard.getSquare(x0,temp).getContent()!=null){
                                rat_in_river=true;
                            }
                        }
                    }
                    if(y0==dy){
                        for (int temp=min(x0,dx)+1; temp<max(x0,dx); temp++) {
                            if(chessboard.getSquare(temp,y0).getContent()!=null){
                                rat_in_river=true;
                            }
                        }
                    }
                    if(!rat_in_river){
                        chessboard.moveTo(index,chessboard.coordinate2index(dx,dy));
                    }else{
                        System.out.println("Invalid move. Please try again.");
                        continue;
                    }
                }
            }else{
                System.out.println("Invalid move. Please try again.");
                continue;
            }


            player_turn=3-player_turn;
        }

        printChessBoard(chessboard);
        System.out.println("Player "+checkWinner()+" wins.");
    }
    public static void printChessBoard(ChessBoard board){
        System.out.println("----------------------------");
        for(int r=9; r>=1; r--){
            System.out.print(" "+r+" - ");
            for(int c=1; c<=7; c++){
                System.out.print(board.getSquare(r,c));
            }
            System.out.println();
        }
        System.out.println("      |  |  |  |  |  |  | ");
        System.out.println("      1  2  3  4  5  6  7 ");
        System.out.println("----------------------------");
    }


    public static int checkWinner(){
        /**
         * returns 0 if no winner
         * 1 if player 1 wins
         * 2 if player 2 wins
         */
        return 0;
    }

}
