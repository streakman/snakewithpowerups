package me.streeK.snake.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import me.streeK.snake.entities.Player;
import me.streeK.snake.entities.Player.Direction;
import me.streeK.snake.game.GameLogic;

public class Keylistener implements KeyListener {

  private static Direction currentInputMoveDirection = Direction.RIGHT;

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    Player player = GameLogic.activePlayer;

    if (key == KeyEvent.VK_W && player.getCurrentDirection() != Direction.DOWN) {
      currentInputMoveDirection = Direction.UP;
    } else if (key == KeyEvent.VK_A && player.getCurrentDirection() != Direction.RIGHT) {
      currentInputMoveDirection = Direction.LEFT;
    } else if (key == KeyEvent.VK_S && player.getCurrentDirection() != Direction.UP) {
      currentInputMoveDirection = Direction.DOWN;
    } else if (key == KeyEvent.VK_D && player.getCurrentDirection() != Direction.LEFT) {
      currentInputMoveDirection = Direction.RIGHT;
    }

    if (key == KeyEvent.VK_R) {
      GameLogic.initGame();
    }

    if (key == KeyEvent.VK_ESCAPE) {
      GameLogic.isGamePaused = !GameLogic.isGamePaused;
    }
  }

  public static Direction getCurrentInputMoveDirection() {
    return currentInputMoveDirection;
  }

}

