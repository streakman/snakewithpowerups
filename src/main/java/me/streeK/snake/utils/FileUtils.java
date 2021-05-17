package me.streeK.snake.utils;

import java.awt.Image;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Created by CrystallDEV on 17/05/2021
 */
public class FileUtils {

  private final static Logger logger = Logger.getLogger(FileUtils.class.getCanonicalName());

  public static File loadFileFromResources(String name) {
    File file = new File(Thread.currentThread().getContextClassLoader().getResource(name).getFile());
    if (!file.isFile()) {
      logger.severe("Unable to find imageicon with the name: " + name);
      return null;
    }
    return file;
  }

  public static Image loadImageFromResources(String name) {
    File file = loadFileFromResources(name);
    if (file == null) {
      return null;
    }
    return new ImageIcon(file.getAbsolutePath()).getImage();
  }
}
