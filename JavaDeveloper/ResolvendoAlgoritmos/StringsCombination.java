import java.util.Scanner;

public class StringsCombination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = Integer.parseInt(scanner.nextLine());
        CharSequence[] strings;
        CharSequence greatestLengthString;
        CharSequence lesserLengthString;
        int greatestStrLength;
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < numTestCases; i++) {
            strings = scanner.nextLine().split(" ");

            greatestStrLength = (strings[0].length() >= strings[1].length()) ? strings[0].length() : strings[1].length();
                
            for(int j = 0; j < greatestStrLength; j++){
                if(j < strings[0].length()){
                    strBuilder.append(strings[0].charAt(j));
                }
                if(j < strings[1].length()){
                    strBuilder.append(strings[1].charAt(j));
                }
            }

            System.out.println(strBuilder.toString());

            strBuilder = new StringBuilder();
        }
    }
}
