import java.io.IOException;
import java.util.*;

public class SortingStrByLength{    
  private String name;
  private String uniformSize;
  private String uniformColor;

  public void printStudentInfos(){
      System.out.println(this.uniformColor + " " + uniformSize + " " + name);
  }
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.nextLine();
    String[] stringsArray = new String[50];
    String allStrings;

    for(int i = 0; i < N; i++){
      allStrings = scanner.nextLine();
      stringsArray = allStrings.split(" ");

      ArrayList<String> stringsList = new ArrayList<>();
      for(var str : stringsArray){
          stringsList.add(str);
      }

      Collections.sort(stringsList,  new StringsComparator());

      stringsList.forEach((str) -> System.out.print(str + " "));
      System.out.println();
    }

    scanner.close();
  }

  static class StringsComparator implements Comparator<String>{
    @Override
    public int compare(String str0, String str1) {
      int res = 0;
      if(str0.length() > str1.length()){
        res = 1;
      }else if(str0.length() < str1.length()){
        res = -1;
      }
    
      if(res == 0){
        res = str0.compareToIgnoreCase(str1);
        res = res > 0? -1: 1;
      }

    return -res;
  }
  }

}

