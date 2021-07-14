import java.io.IOException;
import java.util.*;

public class CampCompetition {

  String name;
  int value;

  public CampCompetition(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();

    List<CampCompetition> competitors = new ArrayList<>();
    String name;
    int value;
    String winnerName = "";
    int countNum = 0;
    // initialValue%competitors.size()

    while (N > 0) {
      for (int i = 0; i < N; ++i) {
        name = scanner.next();
        value = scanner.nextInt();
        scanner.nextLine();

        competitors.add(new CampCompetition(name, value));
      }

      countNum = competitors.get(0).value;
      int removeIndex, currentIndex = 1;

      if (countNum % 2 == 0) {
        currentIndex = competitors.size() - 1;
      }

      while (competitors.size() > 1) {

        if (countNum % 2 == 0) {
          for (int i = 0; i < countNum - 1; i++) {
            if (currentIndex == 0) {
              currentIndex = competitors.size() - 1;
            } else {
              currentIndex--;
            }
            //System.out.println(competitors.get(currentIndex).name);
          }
        } else {
          for (int i = 0; i < countNum - 1; i++) {
            if (currentIndex == competitors.size() - 1) {
              currentIndex = 0;
            } else {
              currentIndex++;
            }
            //System.out.println(competitors.get(currentIndex).name);
          }
        }
        removeIndex = currentIndex;

        countNum = competitors.get(removeIndex).value;

        currentIndex = findNewCurrentIndex(countNum, currentIndex, removeIndex, competitors);

        competitors.remove(removeIndex);

        //competitors.forEach(item -> System.out.println(item.name + " " + item.value));
      }

      winnerName = competitors.get(0).name;

      System.out.printf("Vencedor(a): %s\n", winnerName);
      competitors = new ArrayList<>();

      N = scanner.nextInt();
      scanner.nextLine();
    }

    scanner.close();
  }

  static int findNewCurrentIndex(int countNum, int currentIndex, int removeIndex, List<CampCompetition> competitors) {
    if (countNum % 2 == 0) {
      if (removeIndex == 0) {
        currentIndex = competitors.size() - 2;
      } else {
        currentIndex--;
      }
    } else {
      if (removeIndex == competitors.size() - 1) {
        currentIndex = 0;
      }
    }

    return currentIndex;
  }
}
