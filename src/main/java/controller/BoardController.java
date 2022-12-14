package controller;
import model.*;
//import model.BoardStandard;
import utils.*;
import view.*;

import java.util.Scanner;

public class BoardController {

    private final ChessBoard model;
    private final BoardView view;
    private Location userInputLocation;
    private static final Scanner scanner = new Scanner(System.in);

    //1 or 2
    private int player_turn;

    // Initialize a saved ChessBoard
    public BoardController(BoardView v, Location[][] savedPositions, int playerTurn){
        view = v;
        model = v.getChessBoard();
        model.init(savedPositions);
        player_turn = playerTurn;
    }

    // Initialize by default
    public BoardController(BoardView v){
        this(v, null, 1);
    }

    public ChessBoard getModel() {
        return this.model;
    }

    public static BoardController getController(BoardView v) {
        BoardController boardController = null;

        System.out.println("Welcome to the Jungle!");
        System.out.println("1. Start a New Game");
        System.out.println("2. Load a Saved Game");
        System.out.println("3. End the Game\n");

        int mode = 0;
        do {
            try {
                System.out.println("Please input your preferred mode: ");
                mode = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
//                testing code
//                e.printStackTrace();
            }
        } while (mode < 1 || mode > 3);

        if (mode == 1) return new BoardController(v);
        if (mode == 3) return null;

        do {
            System.out.println("Please enter the name of your saved game: ");
            String fileName = scanner.nextLine();

            try {
                boardController = SaverLoader.load(fileName, v);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (boardController == null);

        return boardController;
    }

    private int dx,dy;


    public void startPlaying(){
        String fileName, temp;

        while(model.checkWinner()==0) {
            updateView();
            if(player_turn==1) {
                System.out.println(ConsoleColors.RED + "Player 1's turn." + ConsoleColors.RESET);
            }else {
                System.out.println(ConsoleColors.BLUE + "Player 2's turn." + ConsoleColors.RESET);
            }
            userInputLocation =null;
            while(userInputLocation ==null) {
                System.out.println("Which piece would you like to move?");
                String s = scanner.nextLine();
                if(s.length()<3){
                    continue;
                }
                switch (s.toLowerCase().substring(0, 3)) {
                    case "rat":
                        userInputLocation = model.getPosition(player_turn - 1, 1);
                        break;
                    case "cat":
                        userInputLocation = model.getPosition(player_turn - 1, 2);
                        break;
                    case "dog":
                        userInputLocation = model.getPosition(player_turn - 1, 3);
                        break;
                    case "wol":
                        userInputLocation = model.getPosition(player_turn - 1, 4);
                        break;
                    case "leo":
                        userInputLocation = model.getPosition(player_turn - 1, 5);
                        break;
                    case "tig":
                        userInputLocation = model.getPosition(player_turn - 1, 6);
                        break;
                    case "lio":
                        userInputLocation = model.getPosition(player_turn - 1, 7);
                        break;
                    case "ele":
                        userInputLocation = model.getPosition(player_turn - 1, 8);
                        break;

                    case "sav":
                        System.out.println("Please name your saved game (only alphabets and numbers can be used): ");
                        fileName = scanner.nextLine();
                        while (!SaverLoader.save(fileName, player_turn, model.getPositions())) {
                            System.out.println("Please name your saved game (only alphabets and numbers can be used): ");
                            fileName = scanner.nextLine();
                        }
                        break;

                    case "exi":
                        System.out.println("Do you want to save current game? (Y/y for yes, otherwise no)");
                        temp = scanner.nextLine();
                        if (temp.length() == 1 && Character.toLowerCase(temp.charAt(0)) == 'y') {
                            System.out.println("Please name your saved game (only alphabets and numbers can be used): ");
                            fileName = scanner.nextLine();
                            while (!SaverLoader.save(fileName, player_turn, model.getPositions())) {
                                System.out.println("Please name your saved game (only alphabets and numbers can be used): ");
                                fileName = scanner.nextLine();
                            }
                        }
                        return;
                }
            }

            boolean flag=true; // check valid input
            dx=0;
            dy=0;
            while(flag){
                System.out.println("Please enter destination:");
                String input = scanner.nextLine();
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
            updateModel();
        }

        updateView();
        System.out.println("Player "+model.checkWinner()+" wins.");
    }

    /**
     * The controller would be manipulating the model once it
     * gets valid inputs, and verify if it's legal move.
     */
    public void updateModel(){
        if(model.checkLegalMove(userInputLocation,new Location(dx, dy))){
            model.moveTo(userInputLocation, new Location(dx, dy));
        }else{
            System.out.println("Invalid move. Please try again.");
            return;
        }
        player_turn=3-player_turn;
    }

    /**
     * Updates the view by printing out another Chess board.
     */
    public void updateView(){
        view.printChessBoard();
    }

    /**
     * Checks if the user would like to back to main menu.
     * @return true  if user inputs Y/y
     */
    public boolean ifCont() {
        System.out.println("Back to the main menu? (Y/y for yes, otherwise no): ");
        String temp = scanner.nextLine();
        boolean result = temp.length() == 1 && Character.toLowerCase(temp.charAt(0)) == 'y';

        try {
            if (!result) scanner.close();
        } catch (Exception e) {
            // testing code
            // e.printStackTrace();
        }
        return result;
    }
}
