package utils;

import controller.BoardController;
import utils.Location;
import view.BoardView;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SaverLoader {
    public static final String SAVE_PATH = "./save/";

    public static void save(String fileName, int playerTurn, Location[][] positions) {
        File file = new File(SAVE_PATH + fileName + ".json");
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
    }

    public static BoardController load(String fileName, BoardView view) {
        BufferedReader loader = null;
        BoardController boardController = null;
        String filePath = SAVE_PATH + fileName + ".json";
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("File " + fileName + " does not exist!");
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
