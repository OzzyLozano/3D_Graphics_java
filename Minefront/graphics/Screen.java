package Minefront.graphics;

import java.util.Random;

import Minefront.src.Game;

public class Screen extends Render {

  private Render test;
  private Render3D render;

  int pxX = 256, pxY = 256;

  public Screen(int width, int height) {
    super(width, height);
    Random random = new Random();
    render = new Render3D(width, height);
    test = new Render(pxX, pxY);
    for (int i = 0; i < pxX * pxY; i++) {
      test.pixels[i] = random.nextInt() * (random.nextInt(5) / 4);
    }
  }

  public void render(Game game) {
    for (int i = 0; i < width * height; i++) {
      pixels[i] = 0;
    }

    render.floor();
    draw(render, 0, 0);

    // for (int i = 0; i < 20; i++) {
    // int animate0 = (int) (Math.sin(System.currentTimeMillis() + (i * i) % 1_000.0
    // / 1_000 * Math.PI * 2) * 100);
    // int animate = (int) (Math.sin((game.time + (i * 2)) % 1_000.0 / 100) * 100);
    // int animate2 = (int) (Math.cos((game.time + (i * 2)) % 1_000.0 / 100) * 100);
    // draw(test, (width - pxX) / 2 + animate, (height - pxY) / 2 - animate2);
    // }
  }

}
