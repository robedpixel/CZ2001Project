import java.util.ArrayList;

// coded by Shyam

public class KMPalgorithm implements SearchAlgorithm {

  void pref_suff_table(String query, int X, int long_ps[]) {
    // length of the previous longest prefix suffix
    int len = 0;
    int i = 1;
    long_ps[0] = 0; // long_ps[0] is always 0

    // the loop calculates long_ps[i] for i = 1 to X-1
    while (i < X) {
      if (query.charAt(i) == query.charAt(len)) {
        len++;
        long_ps[i] = len;
        i++;
      } else // (query[i] != query[len])
      {
        if (len != 0) {
          len = long_ps[len - 1];

          // Also, note that we do not increment
          // i here
        } else // if (len == 0)
        {
          long_ps[i] = len;
          i++;
        }
      }
    }
  }

  public ArrayList<Integer> search(String Genome, String substring, int substring_index) {
    ArrayList<Integer> output = new ArrayList<Integer>();
    int X = substring.length();
    int Y = Genome.length();

    int j = 0; // index for query[]
    int i = 0; // index for DNAseq[]

    int long_ps[] =
        new int[X]; // create long_ps[] that will hold the longest prefix suffix values for pattern

    // Preprocess the pattern (calculate long_ps[] array)
    pref_suff_table(substring, X, long_ps);

    while (i < Y) {
      if (substring.charAt(j) == Genome.charAt(i)) {
        j++;
        i++;
      }
      if (j == X) {
        System.out.println("Found pattern " + "at position " + (i - j));
        output.add(i - j + substring_index);
        j = long_ps[j - 1];
      }

      // mismatch after j matches
      else if (i < Y && substring.charAt(j) != Genome.charAt(i)) {
        // Do not match long_ps[0..long_ps[j-1]] characters,
        // they will match anyway
        if (j != 0) j = long_ps[j - 1];
        else i = i + 1;
      }
    }
    return output;
  }

  void SearchingKMP(String query, String DNAseq) {
    int X = query.length();
    int Y = DNAseq.length();

    int j = 0; // index for query[]
    int i = 0; // index for DNAseq[]

    int long_ps[] =
        new int[X]; // create long_ps[] that will hold the longest prefix suffix values for pattern

    // Preprocess the pattern (calculate long_ps[] array)
    pref_suff_table(query, X, long_ps);

    while (i < Y) {
      if (query.charAt(j) == DNAseq.charAt(i)) {
        j++;
        i++;
      }
      if (j == X) {
        System.out.println("Found pattern " + "at position " + (i - j));
        j = long_ps[j - 1];
      }

      // mismatch after j matches
      else if (i < Y && query.charAt(j) != DNAseq.charAt(i)) {
        // Do not match long_ps[0..long_ps[j-1]] characters,
        // they will match anyway
        if (j != 0) j = long_ps[j - 1];
        else i = i + 1;
      }
    }
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
    KMPalgorithm kmp = new KMPalgorithm();
    kmp.SearchingKMP(query, DNAseq);
    ArrayList<Integer> list = kmp.search(DNAseq, query, 0);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
