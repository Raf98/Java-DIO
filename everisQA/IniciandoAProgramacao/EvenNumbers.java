import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class EvenNumbers {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer num = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= num; i++) {

      if (num > 0) {
        if (i % 2 == 0) {
          System.out.println(i);
        }
      }
    }

  }
}
