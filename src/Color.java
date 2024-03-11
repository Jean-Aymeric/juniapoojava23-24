import java.util.Objects;

public class Color {

  private String name;

  public Color() {
    this("Blanc");
  }

  public Color(final String name) {
    this.name = name;
  }

  public Color(Color other) {
    this(other.name);
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int hashCode() {
    return this.name != null ? this.name.hashCode() : 0;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Color color)) {
      return false;
    }

    return Objects.equals(name, color.name);
  }

  @Override
  public String toString() {
    return "Color{" +
        "name='" + name + '\'' +
        '}';
  }
}
