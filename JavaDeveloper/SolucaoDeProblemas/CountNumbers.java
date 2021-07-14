import java.util.*;

public class CountNumbers {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      int N = input.nextInt();
      SortedMap<Integer, Integer> mapNumbersRepetition = new TreeMap<>();
      int currentNumber;
      
      for(int i = 0; i < N; ++i){
        currentNumber = input.nextInt();
        
        if(mapNumbersRepetition.get(currentNumber) == null){
          mapNumbersRepetition.put(currentNumber, 1);
        } 
        else{
          mapNumbersRepetition.put(currentNumber, mapNumbersRepetition.get(currentNumber)+1);
        }
      }

      input.close();
      
      mapNumbersRepetition.forEach( (key, value) -> System.out.println(key + " aparece " + value + " vez(es)") );
    }
}
