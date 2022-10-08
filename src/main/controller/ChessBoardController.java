package src.main.controller;
import src.main.model.ChessBoard;
import src.main.view.*;
import src.main.model.Chesses.Chess;

import java.util.*;

public class ChessBoardController {

    private ChessBoard model;
    private ChessBoardView view;

    public ChessBoardController(ChessBoard model, ChessBoardView view){
        this.model = model;
        this.view = view;
    }

    // getter, setter to be added later

    public void updateView(){

    }

    public static void init(){
        /**
         * instantiate a chessboard with pieces on initial position
         */

    }

    public static int checkWinner(){
        /**
         * returns 0 if no winner
         * 1 if player 1 wins
         * 2 if player 2 wins
         */
        return 0;
    }

    public static boolean move(Chess piece, int x, int y){
        /**
         * try to move piece to x,y
         * return false if move is invalid
         * otherwise return true and execute the move
         */
        return true;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        init();

        //1 or 2
        int player_turn=1;

        while(checkWinner()==0) {
            ChessBoardView.printChessBoard();

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

        ChessBoardView.printChessBoard();
        System.out.println("Player "+checkWinner()+" wins.");
    }
}
