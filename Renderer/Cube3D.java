package Renderer;

import javax.swing.*;
import java.awt.*;

public class Cube3D extends JFrame {
  private CubePanel cubePanel;

  public Cube3D() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Cube 3D");
    setSize(400, 400);
    setLocationRelativeTo(null);
    cubePanel = new CubePanel();
    add(cubePanel);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Cube3D().setVisible(true));
  }
}

class CubePanel extends JPanel {
  private final int[][] cubeVertices = {
      { 0, 0, 0 },
      { 0, 0, 100 },
      { 0, 100, 0 },
      { 0, 100, 100 },
      { 100, 0, 0 },
      { 100, 0, 100 },
      { 100, 100, 0 },
      { 100, 100, 100 }
  };

  private final int[][] cubeEdges = {
      { 0, 1 },
      { 0, 2 },
      { 0, 4 },
      { 1, 3 },
      { 1, 5 },
      { 2, 3 },
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

    for (int[] edge : cubeEdges) {
      int x1 = cubeVertices[edge[0]][0];
      int y1 = cubeVertices[edge[0]][1];
      int z1 = cubeVertices[edge[0]][2];
      int x2 = cubeVertices[edge[1]][0];
      int y2 = cubeVertices[edge[1]][1];
      int z2 = cubeVertices[edge[1]][2];
      int[] xy1 = project(x1, y1, z1);
      int[] xy2 = project(x2, y2, z2);
      g2.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
      System.out.println(getDepth(
          cubeVertices[edge[0]][0],
          cubeVertices[edge[0]][1],
          cubeVertices[edge[0]][2],
          cameraMovement.viewFrom[0],
          cameraMovement.viewFrom[1],
          cameraMovement.viewFrom[2]));
    }
  }

  public double getDepth(double x, double y, double z, double cameraX, double cameraY, double cameraZ) {
    // Calcular la distancia desde el vertice a la cámara
    double dx = x - cameraX;
    double dy = y - cameraY;
    double dz = z - cameraZ;
    double distance = (double) Math.sqrt(dx * dx + dy * dy + dz * dz);

    // Devolver un valor de profundidad inversamente proporcional a la distancia
    return 1.0 / distance;
  }

  private int[] project(int x, int y, int z) {
    int[] xy = new int[2];
    xy[0] = x - (z / 2);
    xy[1] = y - (z / 2);
    return xy;
  }
}
