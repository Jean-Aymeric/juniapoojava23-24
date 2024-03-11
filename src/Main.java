import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<Car> tab = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      tab.add(new Car());
    }
    tab.add(new Twingo());
    tab.add(new Chiron());
    System.out.println(tab);
    for (Car i : tab) {
      System.out.println(i);
    }
  }
}