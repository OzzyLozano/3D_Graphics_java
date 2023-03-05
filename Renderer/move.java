package Renderer;

public class move extends cameraMovement {

  boolean moving = true;

  move() {
  }

  public void left() {
    cameraMovement.viewFrom[1]--;
    cameraMovement.viewTo[1]--;
  }

  public void right() {
    cameraMovement.viewFrom[1]++;
    cameraMovement.viewFrom[1]++;
  }

  public void front() {
    cameraMovement.viewFrom[0]--;
    cameraMovement.viewFrom[0]--;
  }

  public void back() {
    cameraMovement.viewFrom[0]++;
    cameraMovement.viewFrom[0]++;
  }

  public void jump() {
  }

}
