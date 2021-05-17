package me.streeK.snake.render;

import java.awt.Image;
import me.streeK.snake.utils.FileUtils;

public class Background {

  private Image bgImage;

  public Background(String imageName) {
    bgImage = FileUtils.loadImageFromResources(imageName);
  }

  public Image getBgImage() {
    return bgImage;
  }

  public void setBgImage(Image image) {
    this.bgImage = image;
  }
}
