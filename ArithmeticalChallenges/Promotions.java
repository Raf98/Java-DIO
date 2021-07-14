import java.util.*;

public class Promotions {

  int Q, V;
  double coefficient;

  public Promotions(int Q, int V, double coefficient) {
    this.Q = Q;
    this.V = V;
    this.coefficient = coefficient;
  }

  @Override
  public String toString() {
    return "Q: " + Q + ", V: " + V + ", Coefficient: " + coefficient;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N, M;
    double Q, V;
    int counter = 0;

    while (scanner.hasNext()) {
      N = scanner.nextInt();
      M = scanner.nextInt();

      // System.out.println("Counter: " + counter++);
      // System.out.println("INPUT - N: " + N + " M: " + M);

      List<Promotions> promotionsList = new ArrayList<>();
      HashMap<Integer, Integer> promotionsIndexMap = new HashMap<>();

      int lesserQ = Integer.MAX_VALUE;
      int greaterQ = 0;

      for (int i = 0; i < N; ++i) {
        Q = scanner.nextInt();
        V = scanner.nextInt();

        if (Q < lesserQ) {
          lesserQ = (int) Q;
        }

        if (Q > greaterQ) {
          greaterQ = (int) Q;
        }

        /*
         * if (promotionsIndexMap.get((int) Q) != null) { int sameQPromotionIndex =
         * promotionsIndexMap.get((int) Q); Promotions sameQPromotion =
         * promotionsList.get(sameQPromotionIndex); if (sameQPromotion.coefficient < V /
         * Q) { promotionsList.set(sameQPromotionIndex, new Promotions(sameQPromotion.Q,
         * sameQPromotion.V, V / Q)); //System.out.println("Removed " + Q); } } else {
         * promotionsList.add(new Promotions((int) Q, (int) V, V / Q));
         * promotionsIndexMap.put((int) Q, promotionsList.size() - 1);
         * 
         * }
         */
        promotionsList.add(new Promotions((int) Q, (int) V, V / Q));
      }

      // System.out.println("LesserQ: " + lesserQ);

      Collections.sort(promotionsList, new SortByCoefficient());
      // promotionsList.forEach(p -> System.out.println(p.toString()));

      int currentIndex = 0;
      int maxValue = 0;
      boolean roundUp = false;
      int maxCans = 0;

      while (M > 0) {
        for (int i = M; i > 0; i -= lesserQ) {
          if (i % promotionsList.get(currentIndex).Q == 0) {
            M -= i;
            maxValue += i / promotionsList.get(currentIndex).Q * promotionsList.get(currentIndex).V;
            break;
          }
        }

        // System.out.println("M: " + M);

        ++currentIndex;
        if (currentIndex == promotionsList.size()) {
          currentIndex = 0;
        }
        /*
         * if ((M - promotionsList.get(currentIndex).Q) >= lesserQ || M ==
         * promotionsList.get(currentIndex).Q) { M -=
         * promotionsList.get(currentIndex).Q; System.out.println("M: " + M); } else {
         * ++currentIndex; }
         */
        /*
         * if (promotionsList.get(currentIndex).Q <= M && containsDivider(M,
         * promotionsList.get(currentIndex).Q, promotionsList, lesserQ) || (roundUp &&
         * isPrime(M))) { M -= promotionsList.get(currentIndex).Q; //
         * System.out.println("M: " + M); maxValue +=
         * promotionsList.get(currentIndex).V; // System.out.println("Q : " +
         * promotionsList.get(currentIndex).Q + " V: " + //
         * promotionsList.get(currentIndex).V); // System.out.println("MAX VALUE: " +
         * maxValue); currentIndex = 0; } else { ++currentIndex; if (currentIndex ==
         * promotionsList.size()) { currentIndex = 0; roundUp = true; } }
         */
      }

      System.out.println(maxValue);

    }
    scanner.close();

  }

  static class SortByCoefficient implements Comparator<Promotions> {
    public int compare(Promotions p1, Promotions p2) {
      if (p2.coefficient < p1.coefficient)
        return -1;
      if (p2.coefficient > p1.coefficient)
        return 1;
      return 0;
    }
  }

  static boolean containsDivider(int M, int Q, List<Promotions> promotionsList, int lesserQ) {
    for (var promotion : promotionsList) {
      if (((M - Q) % promotion.Q == 0 && ((M - Q) >= lesserQ || (M - Q) == 0))
          || ((M - (Q * 2)) % promotion.Q == 0 && ((M - (Q * 2)) >= lesserQ || (M - (Q * 2)) == 0))) {
        // System.out.println("M: " + M + ", Q: " + Q + " , P.Q: " + promotion.Q);
        // System.out.println("M - Q: " + (M - Q) % promotion.Q + ", M -(Q*2): " + (M -
        // (Q * 2)) % promotion.Q);
        // if((M - Q) == 0)
        return true;
      }
    }
    return false;
  }

  static boolean isPrime(int num) {
    for (int i = 2; i <= num / 2; ++i) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}