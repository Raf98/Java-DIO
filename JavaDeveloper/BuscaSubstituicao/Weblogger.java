import java.util.*;

public class Weblogger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StringBuilder HTMLLine = new StringBuilder();
        int countAsterisk = 0;
        int countUnderline = 0;
        ArrayList<String> outputs = new ArrayList<>();

        while (true) {

            String replaceStr = null;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '*') {
                    replaceStr = "<b>" + countAsterisk++;
                } else if (line.charAt(i) == '_') {
                    replaceStr = "<i>" + countUnderline++;
                } else {
                    replaceStr = String.valueOf(line.charAt(i));
                }

                HTMLLine.append(replaceStr);
            }

            line = HTMLLine.toString();
            line = line.replaceAll("<i>[0-9]*[02468]", "<i>").replaceAll("<i>[0-9]*[13579]", "</i>")
                    .replaceAll("<b>[0-9]*[02468]", "<b>").replaceAll("<b>[0-9]*[13579]", "</b>");

            outputs.add(line);

            if (scanner.hasNext()) {
                line = scanner.nextLine();
            } else {
                break;
            }
            countAsterisk = 0;
            countUnderline = 0;
            HTMLLine = new StringBuilder();
        }

        outputs.forEach(System.out::println);
        System.out.println();
        scanner.close();
    }
}
