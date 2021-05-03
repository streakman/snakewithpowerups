package me.streeK.snake.entities;

import me.streeK.snake.game.GameLogic;

public class Powerup extends Entity {

  public Powerup() {
    super("powerup.png");
    generateRandomCords();
    while (GameLogic.checkIfEntityWouldSpawnInPlayer(this)) {
      generateRandomCords();
    }
  }

}

