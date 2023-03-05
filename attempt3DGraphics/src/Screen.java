package attempt3DGraphics.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import attempt3DGraphics.graphics.Polygon3D;
import attempt3DGraphics.graphics.PolygonClass;

public class Screen extends JPanel implements KeyListener {

  double sleepTime = 1_000 / 30, lastRefresh = 0;
  public static double ViewFrom[] = { 10, 10, 10 };
  public static double ViewTo[] = { 5, 0, 0 };
  public static int NumOfPolygons = 0, NumOf3DPolygons = 0;
  public static PolygonClass[] drawablePolygon = new PolygonClass[100];
  public static Polygon3D[] polygons3D = new Polygon3D[100];

  Polygon3D poly3D;

  public Screen() {

    polygons3D[NumOf3DPolygons] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 0, 0, 2, 2 },
        new double[] { 0, 0, 0, 0 },
        Color.cyan);
    polygons3D[NumOf3DPolygons] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 0, 0, 2, 2 },
        new double[] { 2, 2, 2, 2 },
        Color.cyan);
    polygons3D[NumOf3DPolygons] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 0, 0, 0, 0 },
        new double[] { 0, 0, 2, 2 },
        Color.cyan);
    polygons3D[NumOf3DPolygons] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 2, 2, 2, 2 },
        new double[] { 0, 0, 2, 2 },
        Color.cyan);
    polygons3D[NumOf3DPolygons] = new Polygon3D(new double[] { 2, 2, 2, 2 }, new double[] { 0, 2, 2, 0 },
        new double[] { 2, 2, 0, 0 },
        Color.cyan);
    polygons3D[NumOf3DPolygons] = new Polygon3D(new double[] { 0, 0, 0, 0 }, new double[] { 0, 2, 2, 0 },
        new double[] { 2, 2, 0, 0 },
        Color.cyan);

    addKeyListener(this);
    setFocusable(true);

  }

  public void paintComponent(Graphics g) {
    // polygon.drawPolygon(g);
    g.clearRect(0, 0, 2000, 1200);
    g.drawString("" + System.currentTimeMillis(), 10, 10);

    for (int i = 0; i < NumOf3DPolygons; i++) {
      polygons3D[i].updatePolygon();
    }

    for (int i = 0; i < NumOfPolygons; i++) {
      drawablePolygon[i].drawPolygon(g);
    }
    sleepNrefresh();
  }

  void sleepNrefresh() {
    while (true) {
      if (System.currentTimeMillis() - lastRefresh > sleepTime) {
        lastRefresh = System.currentTimeMillis();
        repaint();
        break;
      } else {
        try {
          Thread.sleep((long) (System.currentTimeMillis() - lastRefresh));
        } catch (Exception e) {
        }
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A) {
      ViewFrom[0]--;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
      ViewFrom[0]++;
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
      ViewFrom[1]--;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
      ViewFrom[1]++;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

}
