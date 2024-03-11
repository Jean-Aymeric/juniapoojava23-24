import java.util.Objects;

public class Person {

  private String lastName;
  private String firstName;
  private char gender;
  private int age;
  private boolean isMarried = false;

  private Car car;

  public Person() {
    this("nameless", "nameless");
  }

  public Person(String lastName, String firstName) {
    this(lastName, firstName, 'U', 0);
  }

  public Person(String lastName, String firstName, char gender, int age) {
    this.setLastName(lastName);
    this.firstName = firstName;
    this.gender = gender;
    this.setAge(age);
  }

  public Person(Person other) {
    this(other.lastName, other.firstName, other.gender, other.age);
  }

  public void display() {
    System.out.println(this.firstName + " "
        + this.lastName + " "
        + this.gender + " "
        + this.age);
  }

  public void becomesOneYearOlder() {
    this.age++;
  }

  public boolean marry(Person partner) {
    if (this == partner) {
      return false;
    }
    if (this.isMarried || partner.isMarried) {
      return false;
    }
    String temp = this.lastName;
    this.lastName += "-" + partner.lastName;
    partner.lastName += "-" + temp;
    return true;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String lastName) {
    if (lastName != "" && lastName.chars().allMatch(Character::isLetter)) {
      this.lastName = lastName;
      this.lastName = this.lastName.toUpperCase();
    }
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String firstName) {
    if (firstName != "" && firstName.chars().allMatch(Character::isLetter)) {
      this.firstName = firstName;
      this.firstName = this.firstName.toUpperCase();
    }
  }

  public char getGender() {
    return this.gender;
  }

  public void setGender(final char gender) {
    this.gender = gender;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(final int age) {
    this.age = Math.max(age, 0);
  }

  public boolean isMarried() {
    return this.isMarried;
  }

  public void setMarried(final boolean married) {
    this.isMarried = married;
  }

  @Override
  public int hashCode() {
    int result = this.lastName != null ? this.lastName.hashCode() : 0;
    result = 31 * result + (this.firstName != null ? this.firstName.hashCode() : 0);
    result = 31 * result + (int) this.gender;
    result = 31 * result + this.age;
    result = 31 * result + (this.isMarried ? 1 : 0);
    return result;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person person)) {
      return false;
    }

    if (this.gender != person.gender) {
      return false;
    }
    if (this.age != person.age) {
      return false;
    }
    if (this.isMarried != person.isMarried) {
      return false;
    }
    if (!Objects.equals(this.lastName, person.lastName)) {
      return false;
    }
    return Objects.equals(this.firstName, person.firstName);
  }

  @Override
  public String toString() {
    return "Person{" +
        "lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", gender=" + gender +
        ", age=" + age +
        ", isMarried=" + isMarried +
        '}';
  }

  public Car getCar() {
    return this.car;
  }

  public void setCar(final Car car) {
    if (this.car != null) {
      this.car.removeOwner();
    }
    this.car = car;
    if (this != car.getOwner()) {
      car.setOwner(this);
    }
  }

  public void removeCar() {
    if (this.car != null) {
      this.car.removeOwner();
    }
    this.car = null;
  }
}
