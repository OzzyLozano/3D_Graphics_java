package attempt3DGraphics.src;

// import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainClass extends JFrame {
  static JFrame f = new MainClass();
  Screen screen = new Screen();

  public MainClass() {
    add(screen);
    setTitle("3D graphics");
    setUndecorated(false); // cuts the top part
    setSize(1024, 768);
    // setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) {

  }

}
