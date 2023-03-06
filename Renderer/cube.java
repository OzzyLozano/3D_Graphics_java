package Renderer;

public class cube extends draw {

  int size = 100;
  int pos = 100;

  cube(int cube_size, int position) {
    pos = position;
    size = cube_size;
  }

  int[][] cubeVertices = {
      { pos + 0, pos + 0, pos + 0 },
      { pos + 0, pos + 0, pos + size },
      { pos + 0, pos + size, pos + 0 },
      { pos + 0, pos + size, pos + size },
      { pos + size, pos + 0, pos + 0 },
      { pos + size, pos + 0, pos + size },
      { pos + size, pos + size, pos + 0 },
      { pos + size, pos + size, pos + size }
  };

  int[][] cubeEdges = {
      { 0, 1 },
      { 0, 2 },
      { 1, 3 },
      { 2, 3 },
      { 0, 4 },
      { 1, 5 },
      { 2, 6 },
      { 3, 7 },
      { 4, 5 },
      { 4, 6 },
      { 5, 7 },
      { 6, 7 }
  };

}
