import java.io.IOException;
import java.util.Scanner;

public class TopArea{
	
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double soma = 0;
        char O = leitor.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];
        for (int i = 0; i < 12; ++i) {
        	for (int j = 0; j < 12; ++j) {
        		M[i][j] = leitor.nextDouble();
        	}
        }
        
        for (int i = 0; i < 5; ++i) {
        	for (int j = 1; j < 11; ++j) {
        		if (j > i && i + j < 11) soma += M[i][j];
        	}
        }

        if (O == 'M') soma /= ((M.length * M.length) - 24) / 4; 
    	System.out.println(String.format("%.1f", soma));
    }
	
}
