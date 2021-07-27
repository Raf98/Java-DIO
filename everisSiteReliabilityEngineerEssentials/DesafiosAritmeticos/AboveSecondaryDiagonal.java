import java.io.IOException;
import java.util.Scanner;

public class AboveSecondaryDiagonal{
	
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
        
        for (int i = 0; i < 11; ++i) {
        	for (int j = 0; j < 11-i; ++j) {
        		/*if (i + j < 11)*/ soma += M[i][j];
        	}
        }

        if (O == 'M') soma /= ((M.length * M.length) - 12) / 2; // 66
    	System.out.println(String.format("%.1f", soma));
    }
	
}
