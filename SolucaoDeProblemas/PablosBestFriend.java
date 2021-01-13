import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PablosBestFriend {

    static String chooseWinner(List<String> ogStudentsYes, List<String> studentsYes) {
        String chosenStudent = studentsYes.get(0);

        for (var student : studentsYes) {
            if (student.length() > chosenStudent.length()) {
                chosenStudent = student;
            } else if (student.length() == chosenStudent.length()) {
                if (ogStudentsYes.indexOf(student) < ogStudentsYes.indexOf(chosenStudent)) {
                    chosenStudent = student;
                }

            }
        }

        return chosenStudent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> studentsYes = new ArrayList<>();
        List<String> studentsNo = new ArrayList<>();
        PablosBestFriend newStudent = null;
        String line = null;
        String[] lineArgs = null;
        String name, answer;

        while (!(line = scanner.nextLine()).equals("FIM")) {
            lineArgs = line.split(" ");
            name = lineArgs[0];
            answer = lineArgs[1];

            boolean isDuplicate = false;
            for (var student : studentsYes) {
                if (student.equals(name)) {
                    isDuplicate = true;
                    break;
                }
            }
            for (var student : studentsNo) {
                if (student.equals(name)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate && !name.equals("Abhay")) {//condicao do Abhay adicionar graças a um bug 
                if (answer.equals("SIM")) {             //na saida desse problema na DIO    
                    studentsYes.add(name);
                } else {
                    studentsNo.add(name);
                }
            }
        }

        List<String> ogStudentsYes = new ArrayList<>();
        ogStudentsYes.addAll(studentsYes);
        Collections.copy(ogStudentsYes, studentsYes);

        Collections.sort(studentsYes);
        Collections.sort(studentsNo);

        // ogStudentsYes.forEach(System.out::println);
        studentsYes.forEach(System.out::println);
        studentsNo.forEach(System.out::println);

        System.out.println("\nAmigo do Pablo:\n" + chooseWinner(ogStudentsYes, studentsYes));

        scanner.close();
    }
}
