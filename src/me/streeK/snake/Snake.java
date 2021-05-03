package me.streeK.snake;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import me.streeK.snake.game.GameLogic;
import me.streeK.snake.input.Keylistener;
import me.streeK.snake.render.Renderer;

public class Snake extends JPanel {

  private final Renderer renderer = new Renderer();
  public static int ticksPerSecond = Constants.BASE_GAME_SPEED;

  public Snake() {
    setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
    JFrame jFrame = new JFrame("Ssssnake");
    jFrame.setResizable(false);
    jFrame.setVisible(true);
    jFrame.addKeyListener(new Keylistener());
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    ImageIcon gameImageIcon = new ImageIcon("resources/gameicon.png");
    Image gameIcon = gameImageIcon.getImage();
    jFrame.setIconImage(gameIcon);

    jFrame.add(this);
    jFrame.pack();

    Thread renderThread = new Thread(() -> {
      while (GameLogic.inGame) {
        try {
          long timePerTick = (1000 / 60);
          repaint();
          Thread.sleep(timePerTick);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    renderThread.start();

    Thread gameLoop = new Thread(() -> {
      while (GameLogic.inGame) {
        try {
          long timePerTick = (1000 / ticksPerSecond);
          GameLogic.gameLoop();
          Thread.sleep(timePerTick);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    gameLoop.start();

    jFrame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        GameLogic.inGame = false;
        try {
          gameLoop.join();
          renderThread.join();
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        }
        System.exit(0);
      }
    });

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(GameLogic.background.getBgImage(), 0, 0, null);
    renderer.paint((Graphics2D) g);
  }

  public static void main(String[] args) {
    new Snake();
  }

}
