import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFileReader;
import net.sf.jfasta.impl.FASTAElementIterator;
import net.sf.jfasta.impl.FASTAFileReaderImpl;

public class launcher {
  public static void main(String[] args) throws IOException {
    // start timer

    // read Genomes into a list of strings
    LinkedList<String> stringoutput = new LinkedList<String>();
    File file =
        new File(
            "C:\\WLCommonFiles\\Projects\\CZ2007Project\\data\\GCA_000193105.1_Acas_2.0_genomic.fna");
    FASTAFileReader reader = new FASTAFileReaderImpl(file);
    FASTAElementIterator it = reader.getIterator();

    while (it.hasNext()) {
      final FASTAElement el = it.next();
      stringoutput.add(el.getSequence().toUpperCase());
    }

    String genome = new String("ATCATCATCATCATGATC");
    SearchAlgorithm searcher = new CustomAlgorithm2();
    ArrayList<Integer> output;
    System.out.println(stringoutput.get(0));
    output = searcher.search(stringoutput.get(0), "CTACTG", 0);
    System.out.println(output);
    SearchAlgorithm searcher2 = new KMPalgorithm();
    output = searcher2.search(stringoutput.get(0), "CTACTG", 0);
    System.out.println(output);
    if (output.isEmpty() == false) {
      displayFoundPositions(output);
    }
    // end timer
  }

  private static void displayFoundPositions(ArrayList<Integer> positions) {
    for (int i = 0; i < positions.size(); i++) {
      System.out.println("Found pattern " + "at position " + (positions.get(i) + 1));
    }
  }
}
