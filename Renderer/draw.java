package Renderer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class draw extends JPanel implements KeyListener {

  int focalLength = 120;
  public double viewFrom[] = { 10, 10, 10 };
  public boolean isMoving;

  draw() {
    addKeyListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.setRenderingHints(rh);
    g2.translate(getWidth() / 2, getHeight() / 2);
    g2.setColor(Color.black);
    cube Cube = new cube(100, 100);

    for (int i = 0; i < Cube.cubeEdges.length; i++) {
      for (int j = 0; j < 3; j++) {
        try {

          int x1 = (int) ((int) Cube.cubeVertices[Cube.cubeEdges[i][0]][0] - viewFrom[0]),
              y1 = (int) ((int) Cube.cubeVertices[Cube.cubeEdges[i][0]][1] - viewFrom[1]),
              z1 = (int) ((int) Cube.cubeVertices[Cube.cubeEdges[i][0]][2] - viewFrom[2]);
          int x2 = (int) ((int) Cube.cubeVertices[Cube.cubeEdges[i][1]][0] - viewFrom[0]),
              y2 = (int) ((int) Cube.cubeVertices[Cube.cubeEdges[i][1]][1] - viewFrom[1]),
              z2 = (int) ((int) Cube.cubeVertices[Cube.cubeEdges[i][1]][2] - viewFrom[2]);
          int xy1[] = projection(x1, y1, z1);
          int xy2[] = projection(x2, y2, z2);

          g2.drawLine(xy1[0], xy1[1], xy2[0], xy2[1]);
          repaint();
        } catch (Exception e) {
          e.printStackTrace();
        }
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

  public void left() {
    viewFrom[1] -= .1;
  }

  public void right() {
    viewFrom[1] += .1;
  }

  public void front() {
    viewFrom[0] -= .1;
  }

  public void back() {
    viewFrom[0] += .1;
  }

  public void jump() {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A) {
      System.out.println("pressed a");
      isMoving = true;
      left();
    }

    if (e.getKeyCode() == KeyEvent.VK_D) {
      System.out.println("pressed d");
      isMoving = true;
      right();
    }

    if (e.getKeyCode() == KeyEvent.VK_W) {
      System.out.println("pressed w");
      isMoving = true;
      front();
    }

    if (e.getKeyCode() == KeyEvent.VK_S) {
      System.out.println("pressed s");
      isMoving = true;
      back();
    }

    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      System.out.println("pressed space");
      isMoving = true;
      jump();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    isMoving = false;
  }

}
