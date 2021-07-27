import java.io.IOException;
import java.util.Scanner;

public class TheChange{

    public static void main(String[] args) throws IOException {
    	Scanner leitor = new Scanner(System.in);
    	
    	String msg;
    	
    	while (leitor.hasNext()) {
    		int graus = leitor.nextInt();
    		if (graus == 360 || graus >= 0 && graus < 90) msg = "Bom Dia!!";
    		else if (graus >= 90 && graus < 180) msg = "Boa Tarde!!";
    		else if (graus >= 180 && graus < 270) msg = "Boa Noite!!";
    		else msg = "De Madrugada!!";
    		
    		System.out.println(msg);
    	}
    	leitor.close();
    }
    
}
