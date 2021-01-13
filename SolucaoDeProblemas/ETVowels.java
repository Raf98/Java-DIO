import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class ETVowels {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> vowels = new ArrayList<>();
        List<String> sentence = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        while (scanner.hasNext()) {
            String vowelInput = scanner.nextLine().trim().toLowerCase();
            vowels = Arrays.asList(vowelInput.split(""));
            sentence = Arrays.asList(scanner.nextLine().trim().toLowerCase().split(""));

            int countVowels = 0;
            if (vowels.size() > 0) {
                for (var character : sentence) {
                    if (vowels.contains(character) && !character.equals("")) {
                        ++countVowels;
                    }
                }
            }

            outputs.add(countVowels);

            // System.out.println(countVowels);
        }
        scanner.close();
        outputs.forEach(System.out::println);
        System.out.println();
    }
}