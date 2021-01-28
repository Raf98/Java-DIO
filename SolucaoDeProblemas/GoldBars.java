import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoldBars {

  static int cargoCapacity;

  class Edge {
    Vertex destinationVertex;
    int weight;

    Edge(Vertex destinationVertex, int weight) {
      this.destinationVertex = destinationVertex;
      this.weight = weight;
    }
  }

  class Vertex {
    double taxQuantity;
    List<Edge> edgesList;

    public Vertex(int taxQuantity) {
      this.taxQuantity = taxQuantity;
      this.edgesList = new ArrayList<>();
    }

    public void addPath(Vertex destinationVertex, int weight) {
      edgesList.add(new Edge(destinationVertex, weight));
    }

    public int calculateTotalDistance(Vertex previousCity) {
      int totalDistance = 0;
      int travelsNumber = 0;

      for (var edge : edgesList) {
        if (edge.destinationVertex == previousCity) {
          continue;
        }

        totalDistance += edge.destinationVertex.calculateTotalDistance(this);
        travelsNumber = (int) Math.ceil(edge.destinationVertex.taxQuantity / GoldBars.cargoCapacity) * 2;
        totalDistance += travelsNumber * edge.weight;
        this.taxQuantity += edge.destinationVertex.taxQuantity;
      }
      return totalDistance;
    }
  }

  public static void main(String[] args) {

    //long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    Scanner scanner = new Scanner(System.in);
    int N;
    String[] lineArgs;

    lineArgs = scanner.nextLine().split(" ");
    N = Integer.parseInt(lineArgs[0]);
    GoldBars.cargoCapacity = Integer.parseInt(lineArgs[1]);

    List<Vertex> cities = new ArrayList<>();
    List<Integer> taxQuantities = new ArrayList<>();
    Arrays.asList(scanner.nextLine().split(" ")).forEach(taxQuantityStr -> {
      taxQuantities.add(Integer.parseInt(taxQuantityStr));
    });

    GoldBars goldBars = new GoldBars();

    for (int i = 0; i < N; i++) {
      Vertex city = goldBars.new Vertex(taxQuantities.get(i));
      cities.add(city);
    }

    List<String> graphInfos;
    int a, b, c;

    for (int i = 0; i < taxQuantities.size() - 1; ++i) {
      graphInfos = Arrays.asList(scanner.nextLine().split(" "));
      a = Integer.parseInt(graphInfos.get(0)) - 1;
      b = Integer.parseInt(graphInfos.get(1)) - 1;
      c = Integer.parseInt(graphInfos.get(2));

      cities.get(a).addPath(cities.get(b), c);
      cities.get(b).addPath(cities.get(a), c);
    }

    System.out.println(cities.get(0).calculateTotalDistance(null));

    scanner.close();

    //long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    //System.out.println((afterUsedMem-beforeUsedMem) + " bytes");
  }

}
