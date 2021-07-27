import java.io.IOException;
import java.util.Scanner;

public class FibonacciArray{
	
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int T = leitor.nextInt();
        for (int i = 0; i < T; ++i) {
        	int N = leitor.nextInt();
          long anterior = 0, atual = 1, auxiliar;
	        for (int j = 0; j < N; ++j) {
	        	auxiliar = atual;
	        	atual = atual + anterior;
	        	anterior = auxiliar;
	        }
	        System.out.println("Fib("+ N +") = " + anterior);
        }
    }
	
}
