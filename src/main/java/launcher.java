import java.util.ArrayList;

public class launcher {
  public static void main(String[] args) {
    // start timer
    String genome = new String("ATCATCATCATCATGATC");
    SearchAlgorithm searcher = new CustomAlgorithm2();
    ArrayList<Integer> output;
    output = searcher.search(genome, "ATG", 0);
    System.out.println(output.get(0));
    // end timer
  }
}
