package me.streeK.snake.render;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import me.streeK.snake.game.GameLogic;

public class GamePaused {

  private Image gamePausedScreen;

  public GamePaused(String imageName) {
    ImageIcon imageGameOver = new ImageIcon("resources/" + imageName);
    gamePausedScreen = imageGameOver.getImage();
  }

  public void draw(Graphics2D g) {
    if (GameLogic.isGamePaused) {
      g.drawImage(gamePausedScreen, 0, 0, null);
    }
  }

  public Image getGamePausedScreen() {
    return gamePausedScreen;
  }

  public void setGamePausedScreen(Image image) {
    this.gamePausedScreen = image;
  }
}
