import java.util.Objects;

public class Door {

  private String name;

  public Door() {
    this("Normale");
  }

  public Door(final String name) {
    this.name = name;
  }

  public Door(Door other) {
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
    if (!(o instanceof Door color)) {
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
