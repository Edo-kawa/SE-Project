package utils;

import controller.BoardController;
import view.BoardView;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SaverLoader {
    public static final String SAVE_PATH = "./save/";

    /**
     *  Check if the given file name contains only alphabets and numbers
     * @param fileName the file name
     * @return true if only alphabets and numbers are traversed; false otherwise
     */
    public static boolean isValidFileName(String fileName) {
        if (fileName == null) return false;

        char[] temp = fileName.toCharArray();
        for (char c: temp) {
            if ((c <= '9' && c >= '0') || (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) continue;
            return false;
        }
        return true;
    }

    /**
     *  Save the current chess board
     * @param fileName the given file name
     * @param playerTurn indicates who is the player to move a piece
     * @param positions indicates positions of all pieces. The captured pieces are marked with a null value
     * @return true if the given file name is valid; false otherwise
     */
    public static boolean save(String fileName, int playerTurn, Location[][] positions) {
        if (!isValidFileName(fileName)) {
            System.out.println("Invalid File Name!");
            return false;
        }
        if (playerTurn > Side.Blue.getNum() || playerTurn < Side.Red.getNum()) {
            System.out.println("Invalid Player Turn!");
            return false;
        }
        if (positions == null) {
            System.out.println("Invalid Positions");
            return false;
        }

        File file = new File(SAVE_PATH + fileName + ".dat");
        File directory = new File(SAVE_PATH);

        if (!directory.isDirectory()) {
            directory.mkdir();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter saver = null;
        int temp;
        try {
            saver = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8));

            saver.write(Integer.toString(playerTurn));
            saver.newLine();

            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 9; j++) {
                    temp = (positions[i][j] == null)? -1: positions[i][j].getIndex();
                    saver.write(Integer.toString(temp));
                    saver.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (saver != null) {
                    saver.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     *  Load a pre-saved chessboard
     * @param fileName the given file name
     * @param view the view module to display the board
     * @return the generated controller module
     */
    public static BoardController load(String fileName, BoardView view) {
        BufferedReader loader = null;
        BoardController boardController = null;
        String filePath = SAVE_PATH + fileName + ".dat";
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.err.println("File " + fileName + " does not exist!");
            return null;
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            loader = new BufferedReader(inputStreamReader);

            int playerTurn = Integer.parseInt(loader.readLine());

            Location[][] locations = new Location[2][9];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 9; j++) {
                    locations[i][j] = new Location(Integer.parseInt(loader.readLine()));
                }
            }

            boardController = new BoardController(view, locations, playerTurn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (loader != null) {
                    loader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return boardController;
    }
}
