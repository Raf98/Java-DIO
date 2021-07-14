import java.io.IOException;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class ArrayFillIII {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner leitor = new Scanner(System.in);// .useDelimiter(".").useLocale(Locale.ENGLISH);
    double X = 0;
    X = leitor.nextDouble();
    BigDecimal[] N = new BigDecimal[100];
    N[0] = new BigDecimal(X);

    for (int i = 1; i < 100; ++i) {
      N[i] = N[i - 1].divide(new BigDecimal(2));
      // printPositionFormated(i, N[i]);
    }

    leitor.close();

    DecimalFormat decFormat = new DecimalFormat("0.0000");

    // decFormat.setRoundingMode(RoundingMode.HALF_UP);
    // System.out.println(Locale.getDefault());
    for (int i = 0; i < 100; ++i) {
      // System.out.println(String.format("N[" + i + "] = %.4f", N[i]));
      System.out.println("N[" + i + "] = " + decFormat.format(N[i]));
    }
  }

}