import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ProductAndDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal currentNum, resultNum;
        String operator;
        String[] lineArgs;
        int N;

        N = Integer.parseInt(scanner.nextLine());

        resultNum = new BigDecimal("1.0");// 1.0;

        for (int i = 0; i < N; ++i) {
            lineArgs = scanner.nextLine().trim().split(" ");

            currentNum = new BigDecimal(lineArgs[0]);// Double.parseDouble(lineArgs[0]);
            operator = lineArgs[1];

            if (operator.equals("*")) {
                resultNum = resultNum.multiply(currentNum);
                // resultNum *= currentNum;
            } else if (operator.equals("/")) {
                resultNum = resultNum.divide(currentNum, MathContext.DECIMAL128);
                // resultNum /= currentNum;
            }
        }

        System.out.println(resultNum.setScale(0, RoundingMode.DOWN));

        scanner.close();
    }
}
