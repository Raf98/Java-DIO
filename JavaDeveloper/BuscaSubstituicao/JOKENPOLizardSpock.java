import java.util.*;

public class JOKENPOLizardSpock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameRows = scanner.nextInt();
        scanner.nextLine();
        String inputStr[];
        String fernanda, marcia;
        HashMap<String, String[]> JOKENPO_Rules = initializeJOKENPOHashMap();
        String values[];
        int count = 0;

        while (count < gameRows) {

            inputStr = scanner.nextLine().split(" ");
            fernanda = inputStr[0];
            marcia = inputStr[1];

            if (fernanda.toLowerCase().equals(marcia.toLowerCase())) {
                System.out.println("empate");
            } else {
                values = JOKENPO_Rules.get(fernanda.toLowerCase());

                if (values[0].equals(marcia.toLowerCase()) || values[1].equals(marcia.toLowerCase())) {
                    System.out.println("fernanda");
                } else {
                    System.out.println("marcia");
                }
            }

            ++count;
        }

        scanner.close();
    }

    static HashMap<String, String[]> initializeJOKENPOHashMap() {

        HashMap<String, String[]> JOKENPO_Rules = new HashMap<>();

        String values[] = new String[2];
        values[0] = "tesoura";
        values[1] = "lagarto";
        JOKENPO_Rules.put("pedra", values);

        values = new String[2];
        values[0] = "pedra";
        values[1] = "spock";
        JOKENPO_Rules.put("papel", values);

        values = new String[2];
        values[0] = "papel";
        values[1] = "lagarto";
        JOKENPO_Rules.put("tesoura", values);

        values = new String[2];
        values[0] = "spock";
        values[1] = "papel";
        JOKENPO_Rules.put("lagarto", values);

        values = new String[2];
        values[0] = "tesoura";
        values[1] = "pedra";
        JOKENPO_Rules.put("spock", values);
        /*
         * Tesoura corta papel; Papel cobre pedra; Pedra derruba lagarto; Lagarto
         * adormece Spock; Spock derrete tesoura; Tesoura prende lagarto; Lagarto come
         * papel; Papel refuta Spock; Spock vaporiza pedra; Pedra quebra tesoura
         * 
         */

        return JOKENPO_Rules;
    }
}
