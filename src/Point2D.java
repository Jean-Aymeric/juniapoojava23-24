public class Point2D {

  String name;
  int x;
  int y;

  public Point2D() {
    this(0, 0);
  }

  public Point2D(int x, int y) {
    this("Unnamed", x, y);
  }

  public Point2D(String name, int x, int y) {
    this.name = name;
    this.x = x;
    this.y = y;
  }

  public Point2D(Point2D other) {
    this(other.name, other.x, other.y);
  }
}
