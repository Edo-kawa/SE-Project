package main.view;

import main.model.BoardBase;
//import main.model.BoardStandard;
import main.model.Square;
import main.utils.Location;

import java.util.List;
import java.util.Scanner;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class BoardView {
    BoardBase chessBoard;

    public BoardView(){
        init();
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        chessBoard = new BoardBase();
        //1 or 2
        int player_turn=1;

        while(chessBoard.checkWinner()==0) {
            printChessBoard();

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
                        index = chessBoard.getPosition(player_turn - 1, 1);
                        flag=false;
                        break;
                    case "cat":
                        index = chessBoard.getPosition(player_turn - 1, 2);
                        flag=false;
                        break;
                    case "dog":
                        index = chessBoard.getPosition(player_turn - 1, 3);
                        flag=false;
                        break;
                    case "wol":
                        index = chessBoard.getPosition(player_turn - 1, 4);
                        flag=false;
                        break;
                    case "leo":
                        index = chessBoard.getPosition(player_turn - 1, 5);
                        flag=false;
                        break;
                    case "tig":
                        index = chessBoard.getPosition(player_turn - 1, 6);
                        flag=false;
                        break;
                    case "lio":
                        index = chessBoard.getPosition(player_turn - 1, 7);
                        flag=false;
                        break;
                    case "ele":
                        index = chessBoard.getPosition(player_turn - 1, 8);
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
                System.out.println(dx + " " + dy);
                if(dx<1 || dx>9 || dy<1 || dy>7){
                    continue;
                }
                flag=false;
            }
            if(chessBoard.checkLegalMove(index,new Location(dx, dy))){
                chessBoard.moveTo(index, new Location(dx, dy));
            }else{
                System.out.println("Invalid move. Please try again.");
                continue;
            }


            player_turn=3-player_turn;
        }

        printChessBoard();
        System.out.println("Player "+chessBoard.checkWinner()+" wins.");
    }

    void printChessBoard(){
        System.out.println("----------------------------");
        for(int r=9; r>=1; r--){
            System.out.print(" "+r+" - ");
            for(int c=1; c<=7; c++){

                System.out.print(chessBoard.getSquare(new Location(r, c)));
//                System.out.println();
            }
            System.out.println();
        }
        System.out.println("      |  |  |  |  |  |  | ");
        System.out.println("      1  2  3  4  5  6  7 ");
        System.out.println("----------------------------");
    }


}
