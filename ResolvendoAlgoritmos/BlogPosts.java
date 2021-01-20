import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BlogPosts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String blogPost = scanner.nextLine().trim().replaceAll(" +", " ").toLowerCase();
        // System.out.println(blogPost);
        List<String> blogPostStrings;
        StringBuilder builder = new StringBuilder();
        HashMap<Character, String> abbreviatedStringsMap = new HashMap<>();
        HashMap<Character, ArrayList<String>> stringsListMap = new HashMap<>();
        ArrayList<String> abbreviatedStringsList = new ArrayList<>();

        fillMaps(abbreviatedStringsMap, stringsListMap);

        while (!blogPost.equals(".")) {
            if (blogPost.length() > 0) {

                blogPostStrings = Arrays.asList(blogPost.split(" "));

                // coloca todas as strings no ArrayList corresponedente a sua key(letra inicial)
                for (var str : blogPostStrings) {
                    if (stringsListMap.get(str.charAt(0)) != null
                            && !stringsListMap.get(str.charAt(0)).contains(str) & str.length() > 2) {
                        stringsListMap.get(str.charAt(0)).add(str);
                    }
                }

                for (ArrayList<String> list : stringsListMap.values()) {
                    if (list.size() > 0) {

                        String blogPostAltered = blogPost + " ";

                        String betterString = null;
                        int lesserSizeReplace = Integer.MAX_VALUE;
                        for (var word : list) {

                            String replacedWordString = blogPostAltered.replace(word + " ", word.charAt(0) + ". ");

                            // System.out.println("Replaced: " + replacedWordString);
                            // System.out.println("Replaced length: " + replacedWordString.length());

                            if (replacedWordString.length() < lesserSizeReplace) {
                                betterString = word;
                                lesserSizeReplace = replacedWordString.length();
                            }
                        }
                        abbreviatedStringsMap.put(betterString.charAt(0), betterString);
                        abbreviatedStringsList.add(betterString);
                    }
                }

                // abbreviatedStringsList.forEach(System.out::println);

                for (var str : blogPostStrings) { // blogPost.matches("[a-z]")
                    // System.out.println("Current str: " + str);
                    if (abbreviatedStringsMap.get(str.charAt(0)) != null) {

                        if (abbreviatedStringsMap.get(str.charAt(0)).equals(str)) {
                            builder.append(str.charAt(0) + ". ");
                        } else {
                            builder.append(str + " ");
                        }
                    }
                }

                System.out.println(builder.toString().trim());
                System.out.println(abbreviatedStringsList.size());

                Collections.sort(abbreviatedStringsList);
                for (var abbreviatedStr : abbreviatedStringsList) {
                    System.out.println(abbreviatedStr.charAt(0) + ". = " + abbreviatedStr);
                }
            }

            builder = new StringBuilder();
            abbreviatedStringsMap = new HashMap<>();
            abbreviatedStringsList = new ArrayList<>();
            stringsListMap = new HashMap<>();
            fillMaps(abbreviatedStringsMap, stringsListMap);

            blogPost = scanner.nextLine().trim().replaceAll(" +", " ").toLowerCase();
        }
    }

    static void fillMaps(HashMap<Character, String> abbreviatedStringsMap,
            HashMap<Character, ArrayList<String>> stringsListMap) {
        for (int i = 97; i < 123; i++) {
            abbreviatedStringsMap.put(Character.valueOf((char) i), "");
            stringsListMap.put(Character.valueOf((char) i), new ArrayList<>());
        }
    }
}
