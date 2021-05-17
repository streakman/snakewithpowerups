package me.streeK.snake.entities;

import static me.streeK.snake.game.GameLogic.activePlayer;
import static me.streeK.snake.game.GameLogic.checkIfOnApple;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import me.streeK.snake.Constants;
import me.streeK.snake.game.MoveDirection;
import me.streeK.snake.input.Keylistener;
import me.streeK.snake.utils.FileUtils;

public class Player extends Entity {

  private final Image body;
  private final Image headUp = FileUtils.loadImageFromResources("head.png");
  private final Image headDown = FileUtils.loadImageFromResources("headDown.png");
  private final Image headLeft = FileUtils.loadImageFromResources("headLeft.png");
  private final Image headRight = FileUtils.loadImageFromResources("headRight.png");


  private MoveDirection currentMoveDirection = MoveDirection.RIGHT;
  private final List<Location> bodyLocations = new CopyOnWriteArrayList<>();


  public Player() {
    super("headRight.png");
    generateRandomCords();
    this.body = FileUtils.loadImageFromResources("body.png");
  }

  public void move() {
    Location lastHeadLocation = new Location(x, y);

    switch (Keylistener.getCurrentInputMoveDirection()) {
      case UP:
        currentMoveDirection = MoveDirection.UP;
        y -= Constants.DOT_SIZE;
        break;
      case RIGHT:
        currentMoveDirection = MoveDirection.RIGHT;
        x += Constants.DOT_SIZE;
        break;
      case DOWN:
        currentMoveDirection = MoveDirection.DOWN;
        y += Constants.DOT_SIZE;
        break;
      case LEFT:
        currentMoveDirection = MoveDirection.LEFT;
        x -= Constants.DOT_SIZE;
        break;
    }

    if (!checkIfOnApple()) {
      bodyLocations.remove(bodyLocations.size() - 1);
    }
    bodyLocations.add(0, lastHeadLocation);
  }


  public void drawHead(Graphics2D g) {
    if (activePlayer.currentMoveDirection == MoveDirection.LEFT) {
      activePlayer.setImage(headLeft);
    }
    if (activePlayer.currentMoveDirection == MoveDirection.RIGHT) {
      activePlayer.setImage(headRight);
    }
    if (activePlayer.currentMoveDirection == MoveDirection.UP) {
      activePlayer.setImage(headUp);
    }
    if (activePlayer.currentMoveDirection == MoveDirection.DOWN) {
      activePlayer.setImage(headDown);
    }
    g.drawImage(activePlayer.getImage(), x, y, null);
  }

  @Override
  public void generateRandomCords() {
    x = ThreadLocalRandom.current().nextInt(6, 38) * Constants.DOT_SIZE;
    y = ThreadLocalRandom.current().nextInt(6, 38) * Constants.DOT_SIZE;
  }

  public Image getBodyImage() {
    return body;
  }

  public List<Location> getBodyLocations() {
    return bodyLocations;
  }

  public MoveDirection getCurrentDirection() {
    return currentMoveDirection;
  }

  public void addBodyPart(Location location) {
    bodyLocations.add(location);
  }

  public void clearBodyLocations() {
    bodyLocations.clear();
  }
}

