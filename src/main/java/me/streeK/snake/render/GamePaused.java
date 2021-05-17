package me.streeK.snake.render;

import java.awt.Graphics2D;
import java.awt.Image;
import me.streeK.snake.game.GameLogic;
import me.streeK.snake.utils.FileUtils;

public class GamePaused {

  private Image gamePausedScreen;

  public GamePaused(String imageName) {
    gamePausedScreen = FileUtils.loadImageFromResources(imageName);
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
