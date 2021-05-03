package me.streeK.snake.render;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Background {

  private Image bgImage;

  public Background(String imageName) {
    ImageIcon backgroundImage = new ImageIcon("resources/" + imageName);
    bgImage = backgroundImage.getImage();
  }

  public Image getBgImage() {
    return bgImage;
  }

  public void setBgImage(Image image) {
    this.bgImage = image;
  }
}
