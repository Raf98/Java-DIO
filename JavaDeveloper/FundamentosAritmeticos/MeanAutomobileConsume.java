import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MeanAutomobileConsume {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Double X_distance = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Double Y_consumedFuel = Double.parseDouble(st.nextToken());
        
        System.out.printf("%.3f km/l\n", X_distance/Y_consumedFuel);
    }

}