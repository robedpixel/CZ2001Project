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
    boolean stringfound = false;
    Iterator<Character> queueiterator;
    for (int i = 0; i < loopcount; i++) {
      if (substringqueue.getTotal() == searchqueue.getTotal()) {
        stringfound = true;
        queueiterator = searchqueue.descendingIterator();
        for (int j = 0; j < searchqueue.size(); j++) {
          if (Genome.charAt(i + j) != queueiterator.next()) {
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
      if (i != (loopcount - 1)) {
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
    // String query = "TTTATACCTTCC";
    String query = "ATTAAA";
    CustomAlgorithm2 kmp = new CustomAlgorithm2();
    ArrayList<Integer> list = kmp.search(DNAseq, query, 0);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
