package rendererAttempt2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.Container;

public class Block extends Container {

  public int size, x_pos, y_pos, z_pos;
  public int focalLength = 120;
  public boolean blockDestroyed = false;

  Block(int size, int x_pos, int y_pos, int z_pos) {
    setSize(size);
    setX_pos(x_pos);
    setY_pos(y_pos);
    setZ_pos(z_pos);

  }

  public void setSize(int size) {
    this.size = size;
  }

  public void setX_pos(int x_pos) {
    this.x_pos = x_pos;
  }

  public void setY_pos(int y_pos) {
    this.y_pos = y_pos;
  }

  public void setZ_pos(int z_pos) {
    this.z_pos = z_pos;
  }

}
