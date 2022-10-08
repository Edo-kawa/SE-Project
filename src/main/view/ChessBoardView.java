package src.main.view;

import src.main.model.ChessBoard;
import src.main.model.Chesses.Chess;
import src.main.model.Observer;

import java.util.Scanner;

/**
 * @Author Anthony Z.
 * @Date 6/10/2022
 * @Description:
 */
public class ChessBoardView implements Observable{

    public ChessBoardView(){
        Scanner scanner = new Scanner(System.in);

        //1 or 2
        int player_turn=1;

        while(checkWinner()==0) {
            //ChessBoardView.printChessBoard(chessBoard);

            if(player_turn==1) {
                System.out.println(ConsoleColors.RED + "Player 1's turn." + ConsoleColors.RESET);
            }else{
                System.out.println(ConsoleColors.BLUE + "Player 2's turn." + ConsoleColors.RESET);
            }
            System.out.println("Which piece would you like to move?");
            String piece = scanner.nextLine();
            System.out.println("Please enter destination:");
            String input= scanner.nextLine();
            int dx = input.charAt(0)-'0';
            int dy = input.charAt(2)-'0';

            //find the piece from string input
            Chess chess = null;

            move(chess, dx, dy);

            player_turn=3-player_turn;
        }

        //ChessBoardView.printChessBoard(chessBoard);
        System.out.println("Player "+checkWinner()+" wins.");
    }

    public static void printChessBoard(ChessBoard board){
        System.out.println("-------------------------");
        for(int r=9; r>=1; r--){
            System.out.print(r+"-");
            for(int c=1; c<=7; c++){
                System.out.print(board.getSquare(r,c));
            }
            System.out.println();
        }
        System.out.println("  |||||||\n  1234567");
    }


    public static int checkWinner(){
        /**
         * returns 0 if no winner
         * 1 if player 1 wins
         * 2 if player 2 wins
         */
        return 0;
    }

    /**
     * this method should be deleted later
     * @param piece
     * @param x
     * @param y
     * @return
     */
    public static boolean move(Chess piece, int x, int y){
        /**
         * try to move piece to x,y
         * return false if move is invalid
         * otherwise return true and execute the move
         */
        return true;
    }



    @Override
    public void notifyObservers() {


        //chessboard.refreshData(this);
    }
}
