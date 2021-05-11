package me.streeK.snake.game;

import java.io.FileWriter;
import java.io.IOException;

public class HighScore {

    private int currentScore = 0;
    private int highScore = 0;
    private FileWriter scoreFile;

    public HighScore() {
        try {
            scoreFile = new FileWriter("resources/highscore.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkIfNewHighscore() {
        try {
            if (currentScore > highScore) {
                highScore = currentScore;
                scoreFile.write(String.valueOf(highScore));
                scoreFile.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increaseScore() {
        currentScore ++;
    }
}

