import java.util.*;

public class Dividers {

  static int A, B, C, D;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    A = scanner.nextInt();
    B = scanner.nextInt();
    C = scanner.nextInt();
    D = scanner.nextInt();

    // boolean nExists = false;
    int n = -1;

    /*
     * for(int i = A; i <= C; i+=A){ if( (i % A == 0) && (i % B != 0) && (C % i ==
     * 0) && (D % i != 0)){ System.out.println(i); nExists = true; break; } }
     */

    int sqrtC = (int) Math.sqrt(C);

    for (int i = 1; i <= sqrtC; ++i) {
      // System.out.println(C);
      if (C % i == 0) {
        if (checkConditionsABD(i)) {
          n = i;
          break;
        } else if (checkConditionsABD(C / i)) {
          n = C / i;
        }
      }
    }

    System.out.println(n);

    /*
     * if (!nExists) { System.out.println(-1); }
     */

    scanner.close();

  }

  static boolean checkConditionsABD(int i) {
    if ((i % A == 0) && (i % B != 0) && (D % i != 0)) {
      return true;
    }

    return false;
  }
}