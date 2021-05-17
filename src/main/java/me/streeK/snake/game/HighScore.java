package me.streeK.snake.game;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import me.streeK.snake.utils.FileUtils;

public class HighScore {

  private int currentScore = 0;
  private final File file = FileUtils.loadFileFromResources("highscore.txt");
  private int highScore;

  public HighScore() {
//    highScore = getHighScoreFromFile();
  }

  public void checkIfNewHighscore() {
    try {
      if (currentScore > highScore) {
        highScore = currentScore;
        Files.writeString(Path.of(file.getPath()), String.valueOf(highScore));
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
      Path path = Path.of(file.getPath());
      if (!Files.exists(path)) {
        Files.createFile(path);
        Files.writeString(path, "0");
      }
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

