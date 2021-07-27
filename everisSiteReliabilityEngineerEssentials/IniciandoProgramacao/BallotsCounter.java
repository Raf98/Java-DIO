import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BallotsCounter {

    private int iterNum, num;
    private final int ballotsArray[] = { 100, 50, 20, 10, 5, 2, 1 };
    private int ballotsCountArray[];

    public BallotsCounter(int num) {
        this.iterNum = num;
        this.num = num;
        this.ballotsCountArray = new int[7];
    }

    public void calcBallots() {

        for (int i = 0; i < this.ballotsArray.length; i++) {
            if (this.iterNum >= this.ballotsArray[i]) {
                calcBallot(this.ballotsArray[i], i);
            }
        }
    }

    public void calcBallot(int ballotValue, int i) {
        this.ballotsCountArray[i] = this.iterNum / ballotValue;
        this.iterNum -= (this.ballotsCountArray[i]*this.ballotsArray[i]);
    }

    public void printBallots() {
        System.out.println(this.num);
        for (int i = 0; i < this.ballotsCountArray.length; i++) {
            printBallot(i);
        }
    }

    public void printBallot(int i) {
        System.out.printf("%d nota(s) de R$ %d,00\n", ballotsCountArray[i], ballotsArray[i]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        BallotsCounter ballots = new BallotsCounter(num);
        ballots.calcBallots();

        ballots.printBallots();
    }

}
