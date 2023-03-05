package Renderer;

import javax.swing.JFrame;

public class window extends JFrame {

  int WIDTH = 640, HEIGHT = 420;

  window() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("window");
    setSize(WIDTH, HEIGHT);
    setVisible(true);
  }

}
