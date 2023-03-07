package rendererAttempt2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class BlockFacePanel extends JPanel {

  public int size, x_pos, y_pos, z_pos;
  public int focalLength = 120;

  BlockFacePanel(int size, int x_pos, int y_pos, int z_pos) {
    setX_pos(x_pos);
    setY_pos(y_pos);
    setZ_pos(z_pos);
    setSize(size);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.translate(getWidth() / 2, getHeight() / 2);
    g2.setRenderingHints(rh);

    int[] v1 = projection(x_pos, y_pos, z_pos),
        v2 = projection(x_pos + size, y_pos, z_pos),
        v3 = projection(x_pos + size, size + y_pos, z_pos),
        v4 = projection(x_pos, size + y_pos, z_pos);

    // g2.draw3DRect(0, 0, 80, 80, getFocusTraversalKeysEnabled());
    // g2.drawLine(0, 0, 50, 0);
    // g2.drawLine(50, 0, 50, 50);
    // g2.drawLine(50, 50, 0, 50);
    // g2.drawLine(0, 50, 0, 0);
    g2.drawLine(v1[0], v1[1], v2[0], v2[1]);
    g2.drawLine(v1[0], v1[1], v4[0], v4[1]);
    g2.drawLine(v4[0], v4[1], v3[0], v3[1]);
    g2.drawLine(v3[0], v3[1], v2[0], v2[1]);

  }

  int[] projection(int x, int y, int z) {
    int[] v = new int[2];
    v[0] = x * focalLength / (focalLength + z);
    v[1] = y * focalLength / (focalLength + z);
    return v;
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
