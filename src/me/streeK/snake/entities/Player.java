package me.streeK.snake.entities;

import static me.streeK.snake.game.GameLogic.checkIfOnApple;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.ImageIcon;
import me.streeK.snake.Constants;
import me.streeK.snake.input.Keylistener;

public class Player extends Entity {

  private final Image body;
  private Direction currentDirection = Direction.RIGHT;
  private final List<Location> bodyLocations = new CopyOnWriteArrayList<>();


  public Player() {
    super("head.png");
    generateRandomCords();
    ImageIcon imageEntity = new ImageIcon("resources/body.png");
    this.body = imageEntity.getImage();
  }

  public void move() {
    Location lastHeadLocation = new Location(x, y);

    switch (Keylistener.getCurrentInputMoveDirection()) {
      case UP:
        currentDirection = Direction.UP;
        y -= Constants.DOT_SIZE;
        break;
      case RIGHT:
        currentDirection = Direction.RIGHT;
        x += Constants.DOT_SIZE;
        break;
      case DOWN:
        currentDirection = Direction.DOWN;
        y += Constants.DOT_SIZE;
        break;
      case LEFT:
        currentDirection = Direction.LEFT;
        x -= Constants.DOT_SIZE;
        break;
    }

    if (!checkIfOnApple()) {
      bodyLocations.remove(bodyLocations.size() - 1);
    }
    bodyLocations.add(0, lastHeadLocation);
  }


  public void drawHead(Graphics2D g) {
    g.drawImage(getImage(), x, y, null);
  }

  public Image getBodyImage() {
    return body;
  }

  public List<Location> getBodyLocations() {
    return bodyLocations;
  }

  public Direction getCurrentDirection() {
    return currentDirection;
  }

  public void setCurrentDirection(Direction currentDirection) {
    this.currentDirection = currentDirection;
  }

  public enum Direction {
    UP, RIGHT, DOWN, LEFT;

  }

  public void addBodyPart(Location location) {
    bodyLocations.add(location);
  }

  public void clearBodyLocations() {
    bodyLocations.clear();
  }
}

