package Minefront.src;

import javax.swing.JFrame;

import Minefront.graphics.Render;
import Minefront.graphics.Screen;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Display extends Canvas implements Runnable {

  public static final int WIDTH = 900;
  public static final int HEIGHT = 600;
  static final String title = "title";

  private Screen screen;
  private Render render;
  private Game game;
  private Thread thread;
  private boolean running = false;
  private BufferedImage img;
  private int[] pixels;

  public Display() {
    Dimension size = new Dimension();
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    screen = new Screen(WIDTH, HEIGHT);
    game = new Game();
    img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
  }

  void start() {
    System.out.println("starting...");

    if (running)
      return;
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  void stop() {
    System.out.println("stopping...");

    if (!running)
      return;
    running = false;
    try {
      thread.join();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  public void run() {
    System.out.println("running...");

    int frames = 0;
    double unprocessedSeconds = 0;
    long previousTime = System.nanoTime();
    double secondsPerTick = 1 / 60.0;
    int tickCount = 0;
    boolean ticked = false;

    while (running) {
      long currentTime = System.nanoTime();
      long passedTime = currentTime - previousTime;
      previousTime = currentTime;
      unprocessedSeconds += passedTime / 1_000_000_000.0;
      while (unprocessedSeconds > secondsPerTick) {
        tick();
        unprocessedSeconds -= secondsPerTick;
        ticked = true;
        tickCount++;
        if (tickCount % 60 == 0) {
          System.out.println("fps: " + frames);
          previousTime += 1_000;
          frames = 0;
        }
      }
      if (ticked) {
        render();
        frames++;
      }
      render();
      frames++;
    }
  }

  private void tick() {
    game.tick();
  }

  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(3);
      return;
    }

    screen.render(game);

    for (int i = 0; i < WIDTH * HEIGHT; i++) {
      pixels[i] = screen.pixels[i];
    }

    Graphics g = bs.getDrawGraphics();
    g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
    g.dispose();
    bs.show();

  }

  public static void main(String[] args) {
    Display game = new Display();
    JFrame frame = new JFrame();
    frame.add(game);
    frame.pack();
    frame.setSize(WIDTH, HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setTitle(title);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    game.start();
  }
}
