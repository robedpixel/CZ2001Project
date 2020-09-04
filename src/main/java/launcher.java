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
    output = searcher.search(stringoutput.get(0), "ATG", 0);
    if (output.isEmpty() == false) {
      System.out.println(output.get(0));
    }
    // end timer
  }
}
