package attempt3DGraphics.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import attempt3DGraphics.src.Screen;

public class PolygonClass {
  Polygon p;
  Color c;

  public PolygonClass(double[] x, double[] y, Color c) {
    Screen.NumOfPolygons++;
    p = new Polygon();
    for (int i = 0; i < x.length; i++) {
      p.addPoint((int) x[i], (int) y[i]);
    }
    this.c = c;
  }

  public void drawPolygon(Graphics g) {
    g.setColor(c);
    g.fillPolygon(p);
    g.setColor(Color.black);
    g.drawPolygon(p);
  }

}
