package attempt3DGraphics.graphics;

import java.awt.Color;
import java.awt.Polygon;

import attempt3DGraphics.src.Screen;

public class Polygon3D {
  Polygon p;
  Color c;
  double[] x, y, z;
  int polyNum = 0;

  public Polygon3D(double[] x, double[] y, double[] z, Color c) {
    Screen.NumOf3DPolygons++;
    this.x = x;
    this.y = y;
    this.z = z;
    this.c = c;
    createPolygon();
  }

  public void createPolygon() {
    double[] newX = new double[x.length];
    double[] newY = new double[y.length];
    for (int i = 0; i < x.length; i++) {
      newX[i] = 200 * Renderer.calculatePositionX(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
      newY[i] = 200 * Renderer.calculatePositionY(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
    }
    polyNum = Screen.NumOfPolygons;
    Screen.drawablePolygon[Screen.NumOfPolygons] = new PolygonClass(newX, newY, c);
  }

  public void updatePolygon() {
    double[] newX = new double[x.length];
    double[] newY = new double[y.length];
    for (int i = 0; i < x.length; i++) {
      newX[i] = 500 + 50 * Renderer.calculatePositionX(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
      newY[i] = 500 + 50 * Renderer.calculatePositionY(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
    }
    Screen.drawablePolygon[polyNum] = new PolygonClass(newX, newY, c);
    Screen.NumOfPolygons--;
  }

}
