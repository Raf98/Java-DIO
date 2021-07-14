import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class MinhaPrimeiraClasse {
  public static void main(String[] args) throws IOException {

    //Desafio 1	
    /*	
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int total = a+b; // Altere o valor da variável com o cálculo esperado
    System.out.println("X = " + total);
    */

    //Desafio 2
    /*
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int b = Integer.parseInt(st.nextToken());
    int total = a*b; // Altere o valor da variável com o cálculo esperado
    System.out.println("PROD = " + total);    
    //*/

    //Desafio 3
    //*
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int valor1 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int valor2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    double valor3 = Double.parseDouble(st.nextToken());

    double salary = valor2 * valor3; // Altere o valor da variável com o cálculo esperado
    System.out.println("NUMBER = " + valor1);
    System.out.printf("SALARY = U$ %.2f\n", salary);
    //*/
  }
}
