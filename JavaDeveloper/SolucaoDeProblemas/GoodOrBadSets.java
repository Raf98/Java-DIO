import java.util.ArrayList;
import java.util.Scanner;

public class GoodOrBadSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        ArrayList<String> stringsSet = new ArrayList<>();
        boolean isBadSet = false;
        final String BAD_SET = "Conjunto Ruim";
        final String GOOD_SET = "Conjunto Bom";
        String conditionStr = GOOD_SET;

        while (true) {
            N = Integer.parseInt(scanner.nextLine());
            if (N == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                stringsSet.add(scanner.nextLine().toLowerCase().trim());
            }

            int i = 0, j = 0;

            for (i = 0; i < stringsSet.size(); i++) {
                for (j = 0; j < stringsSet.size(); j++) {
                    if (i != j) {

                        if (stringsSet.get(i).startsWith(stringsSet.get(j))
                                || stringsSet.get(j).startsWith(stringsSet.get(i))) {
                            isBadSet = true;
                            conditionStr = BAD_SET;
                            break;
                        }
                        /*
                         * if (stringsSet.get(i).contains(stringsSet.get(j)) ||
                         * stringsSet.get(i).equals(stringsSet.get(j))) {
                         * 
                         * int possiblePrefixLength = stringsSet.get(j).length(); //
                         * System.out.println(possiblePrefixLength);
                         * 
                         * if (stringsSet.get(i).substring(0,
                         * possiblePrefixLength).equals(stringsSet.get(j))) { isBadSet = true;
                         * conditionStr = BAD_SET; break; } }
                         */
                    }

                }
                if (isBadSet) {
                    break;
                }
            }

            System.out.println(conditionStr);

            stringsSet = new ArrayList<>();
            conditionStr = GOOD_SET;
        }

        scanner.close();
    }
}
