import java.io.IOException;
import java.util.Scanner;

public class SundayMorning{
	
    public static void main(String[] args) throws IOException {
    	Scanner leitor = new Scanner(System.in);
    	while (leitor.hasNext()) {
    		String[] relogio = leitor.nextLine().split(":");    		
    		int hora = Integer.parseInt(relogio[0]);
    		int min = Integer.parseInt(relogio[1]);
    		
    		int maxAtraso = 0;
    		
    		if(hora >=7){
    		  maxAtraso = 60*(hora-7) + min;
    		}
    		
    		System.out.println("Atraso maximo: " + maxAtraso);
    	}
    }
	
}