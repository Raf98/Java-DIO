import java.util.ArrayList;
import java.util.Scanner;

public class MagicalHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases, numLines, hashValue, charValue;
        String currentString;

        numTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numTestCases; i++) {
            numLines = Integer.parseInt(scanner.nextLine());
            hashValue = 0;

            ArrayList<String> stringsList = new ArrayList<>();
            for (int j = 0; j < numLines; j++) {
                currentString = scanner.nextLine().trim();

                int charPos = 0;

                for (var letter : currentString.toCharArray()) {
                    hashValue += ((int) letter - (int) 'A') + j + charPos;
                    ++charPos;
                }
            }

            System.out.println(hashValue);
        }
    }
}
