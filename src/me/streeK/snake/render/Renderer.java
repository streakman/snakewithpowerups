package me.streeK.snake.render;

import java.awt.*;

import me.streeK.snake.entities.Apple;
import me.streeK.snake.entities.Location;
import me.streeK.snake.entities.Player;
import me.streeK.snake.entities.Powerup;
import me.streeK.snake.game.GameLogic;

public class Renderer {

  private final GameOver gameOver = new GameOver("gameover.png");
  private final GamePaused gamePause = new GamePaused("gamepaused.png");

  public void paint(Graphics2D g) {
    if (GameLogic.inGame) {
      Apple apple = GameLogic.activeApple;
      Powerup powerup = GameLogic.activePowerup;
      if (apple != null) {
        g.drawImage(apple.getImage(), apple.getX(), apple.getY(), null);
      }
      if (powerup != null) {
        g.drawImage(powerup.getImage(), powerup.getX(), powerup.getY(), null);
      }

      drawPlayer(g);
      g.setFont(new Font("Ink Free", Font.BOLD,30));
      FontMetrics metrics = g.getFontMetrics();
      g.setColor(new Color(255,255,255,62));
      int fontXCord = (500 - metrics.stringWidth("SCORE: " + GameLogic.score.getCurrentScore())) / 2;
      g.drawString("SCORE: " + GameLogic.score.getCurrentScore(),fontXCord, 50);


      if (GameLogic.gameIsOver) {
        gameOver.draw(g);
      }
      if (GameLogic.isGamePaused) {
        gamePause.draw(g);
      }
    }
  }

  private void drawPlayer(Graphics2D g) {
    Player player = GameLogic.activePlayer;
    if (player != null) {
        player.drawHead(g);
      }

      for (Location location : player.getBodyLocations()) {
        g.drawImage(player.getBodyImage(), location.getX(), location.getY(), null);
      }
    }
  }


