package attempt2DGraphics.src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Display {
  int width, height;
  JFrame window = new JFrame();
  JPanel panel;

  Display(int width, int height, String title, int op) {
    this.width = width;
    this.height = height;
    window.setTitle(title);
    window.setBounds(150, 120, width, height);
    window.setDefaultCloseOperation(op);
    window.setVisible(true);
  }

  public void drawRect(Display display) {
    panel = new JPanel() {
      @Override
      public void paint(Graphics g) {
        g.drawRect(20, 29, 60, 60);
      }
    };
    display.window.add(panel);
    SwingUtilities.updateComponentTreeUI(display.window);
  }

  public void fillOval(Display display) {
    panel = new JPanel() {
      @Override
      public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.fillOval(150, 150, 150, 150);

        // Polygon({xAxis1, xAxis2, xAxis[npoints]}, {yAxis1, yAxis2, yAxis[npoints]},
        // npoints)
        graphics2D.fill(new Polygon(new int[] { 50, 20, 80 }, new int[] { 29, 80, 80 }, 3));
      }
    };
    display.window.add(panel);
    SwingUtilities.updateComponentTreeUI(display.window);
  }

}
