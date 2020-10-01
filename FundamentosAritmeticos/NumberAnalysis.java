import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberAnalysis {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int even, odd, positives, negatives;
        even = odd = positives = negatives = 0;

        for (int i = 0; i < 5; i++) {

            st = new StringTokenizer(br.readLine());
            Double num = Double.parseDouble(st.nextToken());

            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            if (num > 0) {
                positives++;
            } else if (num < 0) {
                negatives++;
            }

        }
        
        
        System.out.println( even + " valor(es) par(es)\n" +
                          odd + " valor(es) impar(es)\n" +
                          positives + " valor(es) positivo(s)\n"+
                          negatives + " valor(es) negativo(s)\n");
                          
    }

}