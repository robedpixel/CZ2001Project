import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomAlgorithm2 implements SearchAlgorithm {

  public ArrayList<Integer> search(String Genome, String substring, int substring_index) {
    ArrayList<Integer> output = new ArrayList<Integer>();
    DNAQueue2 substringqueue = new DNAQueue2();
    DNAQueue2 searchqueue = new DNAQueue2();

    // Fill substring queue with substring and searchqueue with initial values in Genome
    for (int i = 0; i < substring.length(); i++) {
      substringqueue.DNAPush(substring.charAt(i));
      searchqueue.DNAPush(Genome.charAt(i));
    }
    // Search through Genome until end of Genome
    int loopcount = Genome.length() - substring.length() + 1;
    int looplimit = loopcount - 1;
    boolean stringfound = false;
    Iterator<Character> queueiterator;
    for (int i = 0; i < loopcount; i++) {
      if (substringqueue.getTotal() == searchqueue.getTotal()) {
        stringfound = true;
        queueiterator = substringqueue.descendingIterator();
        for (int j = 0; j < searchqueue.size(); j++) {
          char input = queueiterator.next();
          if (Genome.charAt(i + j) != input) {
            stringfound = false;
            break;
          }
        }
        // If the string matches add it to the array list
        if (stringfound == true) {
          output.add(i + substring_index);
        }
      }
      // Shift the queue to the right by one
      if (i != looplimit) {
        searchqueue.DNAPop();
        searchqueue.DNAPush(Genome.charAt((i + substring.length())));
      }
    }

    return output;
  }
  // Driver program to test above function
  public static void main(String args[]) {
    String DNAseq =
        "ATTAAAGGTTTATACCTTCCCAGGTAACAAACCAACCAACTTTCGATCTCTTGTAGATCTGTT"
            + "CTCTAAACGAACTTTAAAATCTGTGTGGCTGTCACTCGGCTGCATGCTTAGTGCACTCACGCA"
            + "GTATAATTAATAACTAATTACTGTCGTTGACAGGACACGAGTAACTCGTCTATCTTCTGCAGG"
            + "CTGCTTACGGTTTCGTCCGTGTTGCAGCCGATCATCAGCACATCTAGGTTTCGTCCGGGTGTG"
            + "ACCGAAAGGTAAGATGGAGAGCCTTGTCCCTGGTTTCAACGAGAAAACACACGTCCAACTCAG"
            + "TTTGCCTGTTTTACAGGTTCGCGACGTGCTCGTACGTGGCTTTGGAGACTCCGTGGAGGAGGT"
            + "CTTATCAGAGGCACGTCAACATCTTAAAGATGGCACTTGTGGCTTAGTAGAAGTTGAAAAAGG"
            + "CGTTTTGCCTCAACTTGAACAGCCCTATGTGTTCATCAAACGTTCGGATGCTCGAACTGCACC"
            + "TCATGGTCATGTTATGGTTGAGCTGGTAGCAGAACTCGAAGGCATTCAGTACGGTCGTAGTGG"
            + "TGAGACACTTGGTGTCCTTGTCCCTCATGTGGGCGAAATACCAGTGGCTTACCGCAAGGTTCT"
            + "TCTTCGTAAGAACGGTAATAAAGGAGCTGGTGGCCATAGTTACGGCGCCGATCTAAAGTCATT"
            + "TGACTTAGGCGACGAGCTTGGCACTGATCCTTATGAAGATTTTCAAGAAAACTGGAACACTAA"
            + "ACATAGCAGTGGTGTTACCCGTGAACTCATGCGTGAGCTTAACGGAGGGGCATACACTCGCTA";
    String query = "TTTATACCTTCC";
    // String query = "AAA";
    // SearchAlgorithm searcher = new CustomAlgorithm2();

    // brute force search output
    System.out.println("Brute search");
    SearchAlgorithm searcherbrute = new BruteForce();
    ArrayList<Integer> brutelist;
    Instant start = Instant.now();
    brutelist = searcherbrute.search(DNAseq, query, 0);
    Instant end = Instant.now();
    System.out.println("time taken:" + Duration.between(start, end).toNanos());
    for (int i = 0; i < brutelist.size(); i++) {
      System.out.println("Found pattern " + "at index " + brutelist.get(i));
    }

    // non threaded search output
    System.out.println("custom search");
    SearchAlgorithm searcher = new CustomAlgorithm2();
    ArrayList<Integer> nothreadlist;
    start = Instant.now();
    nothreadlist = searcher.search(DNAseq, query, 0);
    end = Instant.now();
    System.out.println("time taken:" + Duration.between(start, end).toNanos());
    for (int i = 0; i < nothreadlist.size(); i++) {
      System.out.println("Found pattern " + "at index " + nothreadlist.get(i));
    }

    // display threaded search output;
    System.out.println("custom threaded search");
    ArrayList<Integer> list[];
    list = (ArrayList<Integer>[]) new ArrayList[2];
    start = Instant.now();
    ThreadsFunction.Run_Threads(DNAseq, query, list);
    end = Instant.now();
    System.out.println("time taken:" + Duration.between(start, end).toNanos());
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list[i].size(); j++) {
        System.out.println("Found pattern " + "at index " + list[i].get(j));
      }
    }
  }
}
