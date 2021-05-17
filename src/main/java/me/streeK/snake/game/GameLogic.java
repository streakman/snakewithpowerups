package me.streeK.snake.game;



import me.streeK.snake.Constants;
import me.streeK.snake.Snake;
import me.streeK.snake.entities.Apple;
import me.streeK.snake.entities.Entity;
import me.streeK.snake.entities.Location;
import me.streeK.snake.entities.Player;
import me.streeK.snake.entities.Powerup;
import me.streeK.snake.input.Keylistener;
import me.streeK.snake.render.Background;

public class GameLogic {

  public static Apple activeApple;
  public static Powerup activePowerup;
  public static Player activePlayer;
  public static Background background = new Background("background.png");
  public static boolean inGame = true;
  public static boolean gameIsOver = false;
  public static boolean isGamePaused = false;
  private static long activationTime;
  public static HighScore score = new HighScore();

  static {
    initGame();
  }

  public static boolean checkIfOnApple() {
    if (activePlayer.getX() == activeApple.getX() && activePlayer.getY() == activeApple.getY()) {
      score.increaseScore();
      activeApple = new Apple();

      return true;
    }
    return false;
  }


  public static void checkIfOnPowerup() {
    if ((System.currentTimeMillis() - activationTime) >= Constants.POWER_UP_DURATION_MS) {
      Snake.ticksPerSecond = Constants.BASE_GAME_SPEED;
    }
    if (activePlayer.getX() == activePowerup.getX() && activePlayer.getY() == activePowerup.getY()) {
      activationTime = System.currentTimeMillis();
      activePowerup = new Powerup();
      Snake.ticksPerSecond = Constants.BASE_GAME_SPEED * 2;
    }
  }

  public static void checkCollision() {
    if (activePlayer.getX() < Constants.BORDER_MIN_WIDTH
      || activePlayer.getX() >= Constants.BORDER_MAX_WIDTH
      || activePlayer.getY() < Constants.BORDER_MIN_HEIGHT
      || activePlayer.getY() >= Constants.BORDER_MAX_HEIGHT) {
      gameIsOver = true;
      score.checkIfNewHighscore();
    }
    for (Location location : activePlayer.getBodyLocations()) {
      if (activePlayer.getX() == location.getX() && activePlayer.getY() == location.getY()) {
        gameIsOver = true;
        break;
      }
    }
  }

  public static void gameLoop() {
    if (GameLogic.gameIsOver || GameLogic.isGamePaused) {
      return;
    }
    GameLogic.activePlayer.move();
    checkCollision();
    checkIfOnApple();
    checkIfOnPowerup();
  }

  public static boolean checkIfEntityWouldSpawnInPlayer(Entity entity) {
    for (Location location : activePlayer.getBodyLocations()) {
      if ((location.getX() != entity.getX() || activePlayer.getX() != entity.getX()) && (location.getY() != entity.getY() || activePlayer.getY() != entity
        .getY())) {
        return false;
      }
    }
    return true;
  }

  public static void initGame() {
    if (GameLogic.activePlayer != null) {
      GameLogic.activePlayer.clearBodyLocations();
    }
    GameLogic.activePlayer = new Player();
    Keylistener.setCurrentInputMoveDirection(MoveDirection.RIGHT);
    for (int i = 1; i <= Constants.SNAKE_LENGTH; i++) {
      GameLogic.activePlayer.addBodyPart(new Location(activePlayer.getX() - i * Constants.DOT_SIZE, activePlayer.getY()));
    }
    Snake.ticksPerSecond = Constants.BASE_GAME_SPEED;
    GameLogic.activePowerup = new Powerup();
    GameLogic.activeApple = new Apple();
    score.setCurrentScore(0);
    if (GameLogic.gameIsOver) {
      GameLogic.gameIsOver = false;
    }
  }
}


