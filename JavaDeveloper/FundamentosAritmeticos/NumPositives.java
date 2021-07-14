import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// CODIGO QUE FUNCIONOU
public class NumPositives {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int positives = 0;
    StringTokenizer st;

    for (int i = 0; i < 6; i++) {
      st = new StringTokenizer(br.readLine());

      if (Double.parseDouble(st.nextToken()) > 0) {
        ++positives;
      }
    }

    System.out.println(positives + " valores positivos");
  }
}

/*
 * import java.util.Scanner;
 * 
 * class NumPositives { public static void main(String[] args) throws
 * IOException {
 * 
 * int countPositives = 0;
 * 
 * // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 
 * // StringTokenizer st; Scanner scanner = new Scanner(System.in); double num;
 * 
 * for (int i = 0; i < 6; i++) { // st = new StringTokenizer(br.readLine()); num
 * = scanner.nextDouble();
 * 
 * // if(Double.parseDouble(st.nextToken()) > 0) if (num > 0) ++countPositives;
 * }
 * 
 * System.out.println(countPositives + " valores positivos");
 * 
 * } }
 */
