package rendererAttempt2;

public class Run {

  public static void main(String[] args) {
    Window window = new Window();
    BlockFacePanel square = new BlockFacePanel(80, 0, 0, 0);
    BlockFacePanel square1 = new BlockFacePanel(80, 0, 0, -80);
    window.add(square);
    window.add(square1);

    // Cube cube = new Cube(80, 80, 0, -80);
    // Cube cube2 = new Cube(80, 0, 0, -80);
    // window.add(cube);
    // window.add(cube2);
  }

}
