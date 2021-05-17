package me.streeK.snake.entities;

import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;
import me.streeK.snake.utils.FileUtils;

public class Entity {

  protected int x;
  protected int y;
  private Image image;

  public Entity(String imageName) {
    image = FileUtils.loadImageFromResources(imageName);
  }

  public void generateRandomCords() {
    x = (ThreadLocalRandom.current().nextInt(1, 49) * 10);
    y = (ThreadLocalRandom.current().nextInt(1, 49) * 10);
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

}
