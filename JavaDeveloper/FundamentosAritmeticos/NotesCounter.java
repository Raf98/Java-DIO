import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotesCounter {

    private int iterNum, num;
    private final int notesArray[] = { 100, 50, 20, 10, 5, 2, 1 };
    private int notesCountArray[];

    public NotesCounter(int num) {
        this.iterNum = num;
        this.num = num;
        this.notesCountArray = new int[7];
    }

    public void calcNotes() {

        for (int i = 0; i < this.notesArray.length; i++) {
            if (this.iterNum >= this.notesArray[i]) {
                //System.out.println(this.iterNum);
                calcNote(this.notesArray[i], i);
            }
        }
    }

    public void calcNote(int noteValue, int i) {
        this.notesCountArray[i] = this.iterNum / noteValue;
        this.iterNum -= (this.notesCountArray[i]*this.notesArray[i]);
    }

    public void printNotes() {
        System.out.println(this.num);
        for (int i = 0; i < this.notesCountArray.length; i++) {
            printNote(i);
        }
    }

    public void printNote(int i) {
        System.out.printf("%d nota(s) de R$ %d,00\n", notesCountArray[i], notesArray[i]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        NotesCounter notes = new NotesCounter(num);
        notes.calcNotes();

        notes.printNotes();
    }

}