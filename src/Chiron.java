import java.util.Objects;

public class Chiron extends Car {

  private String version;

  public Chiron() {
    this(new Color("Rouge"), "xx-xxx-xx", "Sport");
  }

  public Chiron(final Color color, final String registration, String version) {
    super(color, registration, 2, "Bugatti");
    this.version = version;
  }

  public Chiron(final Chiron other) {
    super(other);
    this.version = other.version;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (this.version != null ? this.version.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Chiron chiron)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    return Objects.equals(version, chiron.version);
  }

  @Override
  public String toString() {
    return "Chiron{" +
        "version='" + version + '\'' +
        "} " + super.toString();
  }
}
