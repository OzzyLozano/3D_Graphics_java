package rendererAttempt2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Cube extends JPanel {

  public int size, x_pos, y_pos, z_pos;
  public int focalLength = 120;
  public boolean cubeDestroyed = false;

  int[][] cubeVertices;
  int[][] cubeEdges;

  Cube(int size, int x_pos, int y_pos, int z_pos) {
    setSize(size);
    setX_pos(x_pos);
    setY_pos(y_pos);
    setZ_pos(z_pos);
    setLayout(null);

    int[][] cubeVertices = {
        { x_pos - size / 2, -size / 2 - y_pos, 0 - z_pos },
        { x_pos - size / 2, -size / 2 - y_pos, size / 2 - z_pos },
        { x_pos - size / 2, size / 2 - y_pos, 0 - z_pos },
        { x_pos - size / 2, size / 2 - y_pos, size / 2 - z_pos },
        { x_pos + size / 2, -size / 2 - y_pos, 0 - z_pos },
        { x_pos + size / 2, -size / 2 - y_pos, size / 2 - z_pos },
        { x_pos + size / 2, size / 2 - y_pos, 0 - z_pos },
        { x_pos + size / 2, size / 2 - y_pos, size / 2 - z_pos }
    };
    int[][] cubeEdges = {
        { 0, 1 },
        { 0, 2 },
        { 1, 3 },
        { 2, 3 },
        { 0, 4 },
        { 1, 5 },
        { 2, 6 },
        { 3, 7 },
        { 4, 5 },
        { 4, 6 },
        { 5, 7 },
        { 6, 7 }
    };
    this.cubeVertices = cubeVertices;
    this.cubeEdges = cubeEdges;
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

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.translate(getWidth() / 2, getHeight() / 2);
    g2.setRenderingHints(rh);

    for (int[] edge : cubeEdges) {
      int x1 = cubeVertices[edge[0]][0];
      int y1 = cubeVertices[edge[0]][1];
      int z1 = cubeVertices[edge[0]][2];
      int x2 = cubeVertices[edge[1]][0];
      int y2 = cubeVertices[edge[1]][1];
      int z2 = cubeVertices[edge[1]][2];
      int[] xy1 = projection(x1, y1, z1);
      int[] xy2 = projection(x2, y2, z2);

      g2.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
    }

  }

  int[] projection(int x, int y, int z) {
    int[] xy = new int[2];
    xy[0] = x * focalLength / (focalLength + z);
    xy[1] = y * focalLength / (focalLength + z);
    return xy;
  }

}
