package main.controller;
import main.model.ChessBoard;
import main.view.ChessBoardView;

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
}
