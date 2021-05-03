package me.streeK.snake.render;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GameOver {

  private Image gameOverScreen;

  public GameOver(String imageName) {
    ImageIcon imageGameOver = new ImageIcon("resources/" + imageName);
    gameOverScreen = imageGameOver.getImage();
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
