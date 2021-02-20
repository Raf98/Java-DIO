import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;

public class MarketShopping {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    ArrayList<String> arrayItems = new ArrayList<>(N);
    String currentItem;
    ArrayList<String> testCaseArray = new ArrayList<>();

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      
      while(st.hasMoreTokens()){
        currentItem = st.nextToken();

        if(testCaseArray.isEmpty() || !testCaseArray.contains(currentItem)){
            testCaseArray.add(currentItem);
          }
      }  
      
      Collections.sort(testCaseArray);
      
      StringBuilder testCaseNoDuplicates = new StringBuilder();

      for(var item : testCaseArray){
          testCaseNoDuplicates.append(item + " ");
      }

      arrayItems.add(testCaseNoDuplicates.toString().trim());

      testCaseArray = new ArrayList<>();
    }

    
    for(var item : arrayItems){
      System.out.println(item);
    }
  }
}

