package me.streeK.snake.game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HighScore {

  private int currentScore = 0;
  private final Path path = Paths.get("resources/highscore.txt");
  private int highScore;

  public HighScore() {
    highScore = getHighScoreFromFile();
  }

  public void checkIfNewHighscore() {
    try {
      if (currentScore > highScore) {
        highScore = currentScore;
        Files.writeString(path, String.valueOf(highScore));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void increaseScore() {
    currentScore++;
  }

  public int getCurrentScore() {
    return currentScore;
  }

  public int getHighScoreFromFile() {
    try {
      return Integer.parseInt(Files.readString(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public void setCurrentScore(int currentScore) {
    this.currentScore = currentScore;
  }

  public int getHighScore() {
    return highScore;
  }
}

