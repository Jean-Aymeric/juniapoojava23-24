import java.util.ArrayList;
import java.util.Objects;

public class Car {

  private Color color;
  private String registration;
  private String brand;
  private ArrayList<Door> doors;

  private Person owner;

  public Car() {
    this(new Color("Blanc"), "xx-xxx-xx", 4, "Inconnu");
  }

  public Car(final Color color, final String registration, final int nbDoors, final String brand) {
    this.color = color;
    this.registration = registration;
    this.brand = brand;
    this.doors = new ArrayList<>();
    for (int i = 0; i < nbDoors; i++) {
      this.doors.add(new Door());
    }
  }

  public Car(Car other) {
    this(other.color, other.registration, other.getNbDoors(), other.brand);
  }

  public int getNbDoors() {
    return this.doors.size();
  }

  public Color getColor() {
    return this.color;
  }

  public void setColor(final Color color) {
    this.color = color;
  }

  public String getRegistration() {
    return this.registration;
  }

  public void setRegistration(final String registration) {
    this.registration = registration;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(final String brand) {
    this.brand = brand;
  }

  @Override
  public int hashCode() {
    int result = this.color != null ? this.color.hashCode() : 0;
    result = 31 * result + (this.registration != null ? this.registration.hashCode() : 0);
    result = 31 * result + this.getNbDoors();
    result = 31 * result + (this.brand != null ? this.brand.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car car)) {
      return false;
    }

    if (this.doors.equals(((Car) o).doors)) {
      return false;
    }
    if (!Objects.equals(color, car.color)) {
      return false;
    }
    if (!Objects.equals(registration, car.registration)) {
      return false;
    }
    return Objects.equals(brand, car.brand);
  }

  @Override
  public String toString() {
    return "Car{" +
        "color='" + color + '\'' +
        ", registration='" + registration + '\'' +
        ", doors=" + this.doors +
        ", brand='" + brand + '\'' +
        '}';
  }

  public Person getOwner() {
    return this.owner;
  }

  public void setOwner(final Person owner) {
    if (this.owner != null) {
      this.owner.removeCar();
    }
    this.owner = owner;
    if (this != owner.getCar()) {
      owner.setCar(this);
    }
  }

  public void removeOwner() {
    this.owner = null;
  }
}
