package Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class cameraMovement extends JPanel implements KeyListener {

  public static double viewFrom[] = { 10, 10, 10 };
  public static double viewTo[] = { 5, 0, 0 };

  cameraMovement() {
    addKeyListener(this);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A)
      new move().left();

    if (e.getKeyCode() == KeyEvent.VK_D)
      new move().right();

    if (e.getKeyCode() == KeyEvent.VK_W)
      new move().front();

    if (e.getKeyCode() == KeyEvent.VK_S)
      new move().back();

    if (e.getKeyCode() == KeyEvent.VK_SPACE)
      new move().jump();
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }
}
