package me.streeK.snake.render;

import java.awt.Graphics2D;
import java.awt.Image;
import me.streeK.snake.utils.FileUtils;

public class GameOver {

  private Image gameOverScreen;

  public GameOver(String imageName) {
    gameOverScreen = FileUtils.loadImageFromResources(imageName);
  }

  public void draw(Graphics2D g) {
    g.drawImage(gameOverScreen, 0, 0, null);
  }

  public Image getGameOverScreen() {
    return gameOverScreen;
  }

  public void setGameOverScreen(Image image) {
    this.gameOverScreen = image;
  }
}
