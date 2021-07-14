import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class GreatestSubstring {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    String str1, str2;
    int greatestSubstringLength;

    while (scanner.hasNextLine()) {

      str1 = scanner.nextLine();
      str2 = scanner.nextLine();

      if (str1.length() >= str2.length()) {
        greatestSubstringLength = checkGreatestSubstringLength(str1, str2);
      } else {
        greatestSubstringLength = checkGreatestSubstringLength(str2, str1);
      }

      System.out.println(greatestSubstringLength);
    }

    scanner.close();
  }

  /*
  static boolean checkStringAcceptable(char[] chars1) {
    short countLetters = 0;

    for (char c : chars1) {
      if (Character.isLetter(c)) {
        countLetters++;
      } else {
        if (!Character.isSpaceChar(c)) {
          return false;
        }
      }
    }
    if (countLetters == 0) {
      return false;
    }

    return true;
  }*/

  static int checkGreatestSubstringLength(String str1, CharSequence str2) {

    int greatestSubstringLength = 0;
    int localSubstringLength = 0;

    for (int i = 0; i < str2.length(); i++) {
      if (str1.contains(Character.toString(str2.charAt(i)))) {
        localSubstringLength = 1;
        StringBuilder subString = new StringBuilder(String.valueOf(str2.charAt(i)));
        // System.out.println("Initial substr " + subString.toString());

        for (int j = i + 1; j < str2.length(); j++) {
          subString.append(String.valueOf(str2.charAt(j)));

          if (!str1.contains(subString)) {
            break;
          }
          localSubstringLength++;
        }

        //System.out.println("Local sbstr len: " + localSubstringLength);

        if (localSubstringLength > greatestSubstringLength) {
          greatestSubstringLength = localSubstringLength;
        }

        localSubstringLength = 0;
      }

    }

    return greatestSubstringLength;
  }

}
