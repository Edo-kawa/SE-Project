package main.controller;
import main.model.BoardBase;
//import main.model.BoardStandard;
import main.utils.Location;
import main.view.*;

import java.util.Scanner;

public class BoardController {
    private final BoardBase model;
    private final BoardView view;

    public BoardController(BoardView v);

    int player_turn;    // 0 for player 1; otherwise player 2
    int dx, dy, index;    // Destination's location
    public void init(); // Initialize the Controller to process user's input

    public void updateModel();  // Update the Model according to user's input

    public void updateView();   // Update the View

}
