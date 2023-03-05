package Renderer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;

public class draw extends JPanel {

  int focalLength = 120;

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.translate(getWidth() / 2, getHeight() / 2);
    g2.setColor(Color.black);
    Cube cube = new Cube(100, 100);

    for (int i = 0; i < cube.cubeEdges.length; i++) {
      for (int j = 0; j < 3; j++) {
        int x1 = cube.cubeVertices[cube.cubeEdges[i][0]][0],
            y1 = cube.cubeVertices[cube.cubeEdges[i][0]][1],
            z1 = cube.cubeVertices[cube.cubeEdges[i][0]][2];
        int x2 = cube.cubeVertices[cube.cubeEdges[i][1]][0],
            y2 = cube.cubeVertices[cube.cubeEdges[i][1]][1],
            z2 = cube.cubeVertices[cube.cubeEdges[i][1]][2];
        int xy1[] = projection(x1, y1, z1);
        int xy2[] = projection(x2, y2, z2);

        g2.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
      }
    }
  }

  int[] projection(int x, int y, int z) {
    int[] xy = new int[2];
    // xy[0] = x - (z / 3);
    // xy[1] = y - (z / 3);
    xy[0] = x * focalLength / (focalLength + z + 128);
    xy[1] = y * focalLength / (focalLength + z + 128);
    return xy;
  }

  public double getDepth(double x, double y, double z, double cameraX, double cameraY, double cameraZ) {
    // Calcular la distancia desde el punto a la cámara
    double dx = x - cameraX;
    double dy = y - cameraY;
    double dz = z - cameraZ;
    double distance = (double) Math.sqrt(dx * dx + dy * dy + dz * dz);

    // Devolver un valor de profundidad inversamente proporcional a la distancia
    return 1.0 / distance;
  }

}
