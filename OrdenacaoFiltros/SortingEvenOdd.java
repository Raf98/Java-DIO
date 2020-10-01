import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;


public class SortingEvenOdd {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    ArrayList<Integer> arrayEven = new ArrayList<>(N);
    ArrayList<Integer> arrayOdd = new ArrayList<>(N);
    int num;

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      num = Integer.parseInt(st.nextToken()); 
      if(num%2 == 0){
        arrayEven.add(num);
      }else{
        arrayOdd.add(num);
      }
    }
    
    Collections.sort(arrayEven);
    Collections.sort(arrayOdd, Collections.reverseOrder()); 
    
    for(var numEven : arrayEven){
      System.out.println(numEven);
    }
    
    for(var numOdd : arrayOdd){
      System.out.println(numOdd);
    }
  }
}