public class Twingo extends Car {

  public Twingo() {
    this(new Color("Rouge"), "xx-xxx-xx");
  }

  public Twingo(final Color color, final String registration) {
    super(color, registration, 4, "Renault");
  }

  public Twingo(final Car other) {
    super(other);
  }
}
