package src.main.controller;
import src.main.model.ChessBoard;
import src.main.view.ChessBoardView;
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
    public static void printChessboard(){
        /**
         * print the chessboard in correct format
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
            printChessboard();

            System.out.println("Player " + player_turn + "'s turn.");
            System.out.println("Which piece would you like to move?");
            String piece = scanner.nextLine();
            System.out.println("Please enter destination:");
            int dx = scanner.nextInt(), dy = scanner.nextInt();

            //find the peice from string input
            Chess chess = null;

            move(chess, dx, dy);

            player_turn=3-player_turn;
        }

        printChessboard();
        System.out.println("Player "+checkWinner()+" wins.");
    }
}
