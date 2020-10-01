import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class EvenNumbers {
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer num = Integer.parseInt(st.nextToken());
        

        for (int i = 1; i <= num; i++){

            if (num > 0){
              if(i%2 == 0){
                  System.out.println(i);
              }
            }
        }


      }
    }

/*
 * //import java.util.ArrayList; //import java.util.Scanner; import
 * java.io.BufferedReader; import java.io.InputStreamReader; import
 * java.io.IOException; import java.util.StringTokenizer;
 * 
 * class EvenNumbers { public static void main(String[] args) throws IOException
 * { BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * int num = 0; StringTokenizer st;
 * 
 * st = new StringTokenizer(br.readLine()); num =
 * Integer.parseInt(st.nextToken());
 * 
 * if (num % 2 == 0 && num != 0) { System.out.println(2);
 * 
 * for (int i = 4; i <= num; i += 2) { System.out.println(i); } }
 * 
 * /* if(args.length == 0) { System.exit(1); }
 * 
 * int numInput = Integer.parseInt(args[0]);
 * 
 * if(numInput <= 0 || numInput%2 != 0) { System.exit(2); }
 */
// Scanner scanner = new Scanner(System.in);

// int num = scanner.nextInt();

/*
 * ArrayList<Integer> evenNumbers = new ArrayList<>(); evenNumbers.add(2);
 * 
 * for(int i=4; i <= numInput; i++) { if(i%2 == 0) evenNumbers.add(i); }
 * 
 * evenNumbers.forEach( even -> System.out.println(even) );
 */

