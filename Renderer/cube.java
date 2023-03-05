package Renderer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JPanel;

public class cube extends JPanel {

  int focalLength = 120;

  int[][] cubeVertices = {
      { 0, 0, 0 },
      { 0, 0, 100 },
      { 0, 100, 0 },
      { 0, 100, 100 },
      { 100, 0, 0 },
      { 100, 0, 100 },
      { 100, 100, 0 },
      { 100, 100, 100 }
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

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.translate(getWidth() / 2, getHeight() / 2);
    g2.setColor(Color.black);
    cameraMovement camera = new cameraMovement();

    for (int i = 0; i < cubeEdges.length; i++) {
      for (int j = 0; j < 3; j++) {
        int x1 = cubeVertices[cubeEdges[i][0]][0],
            y1 = cubeVertices[cubeEdges[i][0]][1],
            z1 = cubeVertices[cubeEdges[i][0]][2];
        int x2 = cubeVertices[cubeEdges[i][1]][0],
            y2 = cubeVertices[cubeEdges[i][1]][1],
            z2 = cubeVertices[cubeEdges[i][1]][2];
        int xy1[] = camera.projection(x1, y1, z1);
        int xy2[] = camera.projection(x2, y2, z2);

        g2.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
      }
    }

    for (int[] vertice : cubeVertices) {
      System.out.println(getDepth(
          vertice[0], vertice[1], vertice[2],
          cameraMovement.viewFrom[0],
          cameraMovement.viewFrom[1],
          cameraMovement.viewFrom[2]));
      System.out.println(vertice[0] + " " + vertice[1] + " " + vertice[2]);
    }
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

  int[] projection(int x, int y, int z) {
    int[] xy = new int[2];
    // xy[0] = x - (z / 3);
    // xy[1] = y - (z / 3);
    xy[0] = x * focalLength / (focalLength + z + 256);
    xy[1] = y * focalLength / (focalLength + z + 256);
    return xy;
  }

}
