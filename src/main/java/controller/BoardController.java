package controller;
import model.*;
//import model.BoardStandard;
import utils.*;
import view.*;

import java.util.Scanner;

public class BoardController {

    private final ChessBoard model;
    private final BoardView view;
    public BoardController(BoardView v){
        view=v;
        model=v.getChessBoard();
        model.init();
    }
    //1 or 2
    int player_turn=1;
    int dx,dy,index;
    public void init(){
        Scanner scanner = new Scanner(System.in);
        while(model.checkWinner()==0) {
            updateView();
            if(player_turn==1) {
                System.out.println(ConsoleColors.RED + "Player 1's turn." + ConsoleColors.RESET);
            }else{
                System.out.println(ConsoleColors.BLUE + "Player 2's turn." + ConsoleColors.RESET);
            }
            index=0;
            boolean flag=true;
            while(flag) {
                System.out.println("Which piece would you like to move?");
                String s = scanner.nextLine();
                if(s.length()<3){
                    continue;
                }
                try{
                    switch (s.toLowerCase().substring(0, 3)) {
                        case "rat":
                            index = model.getPosition(player_turn - 1, 1).getIndex();
                            flag=false;
                            break;
                        case "cat":
                            index = model.getPosition(player_turn - 1, 2).getIndex();
                            flag=false;
                            break;
                        case "dog":
                            index = model.getPosition(player_turn - 1, 3).getIndex();
                            flag=false;
                            break;
                        case "wol":
                            index = model.getPosition(player_turn - 1, 4).getIndex();
                            flag=false;
                            break;
                        case "leo":
                            index = model.getPosition(player_turn - 1, 5).getIndex();
                            flag=false;
                            break;
                        case "tig":
                            index = model.getPosition(player_turn - 1, 6).getIndex();
                            flag=false;
                            break;
                        case "lio":
                            index = model.getPosition(player_turn - 1, 7).getIndex();
                            flag=false;
                            break;
                        case "ele":
                            index = model.getPosition(player_turn - 1, 8).getIndex();
                            flag=false;
                            break;
                    }
                }catch(NullPointerException e){
                    //getPosition() is null means the piece is eaten
                    //do nothing and continue the loop
                }
            }
            flag=true;
            dx=0;
            dy=0;
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
            updateModel();
        }

        updateView();
        System.out.println("Player "+model.checkWinner()+" wins.");
    }
    public void updateModel(){
        if(model.checkLegalMove(new Location(index),new Location(dx, dy))){
            model.moveTo(new Location(index), new Location(dx, dy));
        }else{
            System.out.println("Invalid move. Please try again.");
            return;
        }
        player_turn=3-player_turn;
    }

    public void updateView(){
        view.printChessBoard();
    }

}
