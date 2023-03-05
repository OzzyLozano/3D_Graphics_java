package Minefront.graphics;

import Minefront.src.Display;

public class Render {
  public final int width, height;
  public final int[] pixels;

  public Render(int width, int height) {
    this.width = width;
    this.height = height;
    pixels = new int[width * height];
  }

  public void draw(Render render, int xOffset, int yOffset) {
    for (int y = 0; y < render.height; y++) {
      int yPx = y + yOffset;
      if (yPx < 0 || yPx >= Display.HEIGHT)
        continue;
      for (int x = 0; x < render.width; x++) {
        int xPx = x + xOffset;
        if (xPx < 0 || xPx >= Display.WIDTH)
          continue;

        int alpha = render.pixels[x + y * render.width];
        if (alpha > 0)
          pixels[xPx + yPx * width] = alpha;
      }
    }
  }

}
