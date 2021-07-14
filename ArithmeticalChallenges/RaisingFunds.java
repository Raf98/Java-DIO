import java.util.*;

public class RaisingFunds {

  int B, F, D;
  boolean hasBCond, hasFCond;
  TreeSet<Integer> hasConflictWih;

  public RaisingFunds(int B, int F, int D) {
    this.B = B;
    this.F = F;
    this.D = D;
    this.hasBCond = false;
    this.hasFCond = false;
    this.hasConflictWih = new TreeSet<>();
  }

  @Override
  public String toString() {
    return "B: " + B + ", F: " + F + ", D: " + D;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    ArrayList<RaisingFunds> guestsArray = new ArrayList<>();
    ArrayList<RaisingFunds> chosenGuestsArray = new ArrayList<>();
    ArrayList<RaisingFunds> rejectedGuestsArray = new ArrayList<>();

    int donationsAmount = 0;

    int B, F, D;

    for (int i = 0; i < N; ++i) {
      B = scanner.nextInt();
      F = scanner.nextInt();
      D = scanner.nextInt();
      // System.out.println(B + " " + F + " " + D);
      guestsArray.add(new RaisingFunds(B, F, D));
    }

    Collections.sort(guestsArray, new SortByD());
    guestsArray.forEach(guest -> System.out.println(guest.toString()));

    int i = 0;
    int j = 0;

    for (; i < N; ++i) {

      for (j = 0; j < N; ++j) {
        if (i != j) {
          if (!guestsArray.get(j).hasBCond && !guestsArray.get(j).hasFCond
              && !(guestsArray.get(i).B > guestsArray.get(j).B && guestsArray.get(i).F > guestsArray.get(j).F)
              && !(guestsArray.get(i).B < guestsArray.get(j).B && guestsArray.get(i).F < guestsArray.get(j).F)) {
            if (guestsArray.get(i).B != guestsArray.get(j).B) {
              guestsArray.get(i).hasBCond = true;
              // guestsArray.get(j).hasBCond = true;

              System.out.println(i /* + " and " + j */ + "  with condB");
            }
            if (guestsArray.get(i).F != guestsArray.get(j).F) {
              guestsArray.get(i).hasFCond = true;
              // guestsArray.get(j).hasFCond = true;

              System.out.println(i /* + " and " + j */ + "  with condF");
            }
          }

          if (guestsArray.get(i).hasBCond && guestsArray.get(i).hasFCond) {
            break;
          }
        }
      }

      if (!guestsArray.get(i).hasBCond && !guestsArray.get(i).hasFCond) {
        // System.out.println(i);
        donationsAmount += guestsArray.get(i).D;
        chosenGuestsArray.add(guestsArray.get(i));
      } else {
        rejectedGuestsArray.add(guestsArray.get(i));
      }
    }

    

    System.out.println(donationsAmount);

  }

  static class SortByD implements Comparator<RaisingFunds> {
    public int compare(RaisingFunds r1, RaisingFunds r2) {
      if (r1.D > r2.D)
        return 1;
      if (r1.D < r2.D)
        return -1;
      return 0;
    }
  }
}