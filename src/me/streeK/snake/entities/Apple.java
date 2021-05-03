package me.streeK.snake.entities;

import me.streeK.snake.game.GameLogic;

public class Apple extends Entity {

  public Apple() {
    super("apple.png");
    generateRandomCords();
    while (GameLogic.checkIfEntityWouldSpawnInPlayer(this)) {
      generateRandomCords();
    }
  }
}



