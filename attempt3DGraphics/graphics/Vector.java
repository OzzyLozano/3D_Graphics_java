package attempt3DGraphics.graphics;

public class Vector {
  double x = 0, y = 0, z = 0;

  public Vector(double x, double y, double z) {
    double length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

    if (length > 0) {
      this.x = x / length;
      this.y = y / length;
      this.z = z / length;
    }
  }

  Vector crossProduct(Vector v) {
    Vector crossVector = new Vector(
        y * v.z - z * v.y,
        z * v.x - x * v.z,
        x * v.y - y * v.x);

    return crossVector;
  }

}
