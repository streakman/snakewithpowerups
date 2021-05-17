package me.streeK.snake.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import me.streeK.snake.entities.Player;
import me.streeK.snake.game.GameLogic;
import me.streeK.snake.game.MoveDirection;

public class Keylistener implements KeyListener {

  private static MoveDirection currentInputMoveDirection = MoveDirection.RIGHT;

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

    if (key == KeyEvent.VK_W && player.getCurrentDirection() != MoveDirection.DOWN) {
      currentInputMoveDirection = MoveDirection.UP;
    } else if (key == KeyEvent.VK_A && player.getCurrentDirection() != MoveDirection.RIGHT) {
      currentInputMoveDirection = MoveDirection.LEFT;
    } else if (key == KeyEvent.VK_S && player.getCurrentDirection() != MoveDirection.UP) {
      currentInputMoveDirection = MoveDirection.DOWN;
    } else if (key == KeyEvent.VK_D && player.getCurrentDirection() != MoveDirection.LEFT) {
      currentInputMoveDirection = MoveDirection.RIGHT;
    }

    if (key == KeyEvent.VK_R) {
      GameLogic.initGame();
    }

    if (key == KeyEvent.VK_ESCAPE) {
      GameLogic.isGamePaused = !GameLogic.isGamePaused;
    }
  }

  public static MoveDirection getCurrentInputMoveDirection() {
    return currentInputMoveDirection;
  }

  public static void setCurrentInputMoveDirection(MoveDirection currentInputMoveDirection) {
    Keylistener.currentInputMoveDirection = currentInputMoveDirection;
  }
}

