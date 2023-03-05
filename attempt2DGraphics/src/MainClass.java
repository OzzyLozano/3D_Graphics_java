package attempt2DGraphics.src;

import javax.swing.JFrame;

public class MainClass {

  public static void main(String[] args) {
    Display display = new Display(900, 600, "main window", JFrame.EXIT_ON_CLOSE);

    display.drawRect(display);
    display.fillOval(display);
  }
}
