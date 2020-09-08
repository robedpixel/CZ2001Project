import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFileReader;
import net.sf.jfasta.impl.FASTAElementIterator;
import net.sf.jfasta.impl.FASTAFileReaderImpl;

public class launcher {
  public static void main(String[] args) throws IOException {
    File genomefile = new File("");
    boolean stopped = false;
    LinkedList<String> genomelist = new LinkedList<String>();
    String substring = "";
    String genome = "";
    int genomelistindex = 0;
    int input = 0;
    String stringinput = "";
    Scanner sc = new Scanner(System.in);
    // read Genomes into a list of strings
    System.out.println("Choose an .fna file:");
    JFileChooser filechooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("fna Files", "fna");
    filechooser.setFileFilter(filter);
    int returnVal = filechooser.showOpenDialog(null);
    while (genomefile.isFile() == false) {
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        genomefile = filechooser.getSelectedFile();
      }
    }
    FASTAFileReader reader = new FASTAFileReaderImpl(genomefile);
    FASTAElementIterator it = reader.getIterator();
    while (it.hasNext()) {
      final FASTAElement el = it.next();
      genomelist.add(el.getSequence().toUpperCase());
    }
    while (stopped == false) {
      System.out.println("Choose an option:");
      System.out.println("Current file:" + genomefile.getAbsolutePath());
      System.out.println(
          "Current DNA sequence:" + (genomelistindex + 1) + " of " + genomelist.size());
      System.out.println("Substring to search:" + substring);
      System.out.println(
          "1 = choose new file, 2 = choose DNA sequence, 3 = set substring to search, 4 = search substring in dna sequence, 5 = quit");
      input = sc.nextInt();
      stringinput = sc.nextLine();
      switch (input) {
        case 1:
          System.out.println("Choose an .fna file:");
          returnVal = filechooser.showOpenDialog(null);
          while (genomefile.isFile() == false) {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
              genomefile = filechooser.getSelectedFile();
            }
          }
          reader = new FASTAFileReaderImpl(genomefile);
          it = reader.getIterator();
          while (it.hasNext()) {
            final FASTAElement el = it.next();
            genomelist.add(el.getSequence().toUpperCase());
          }
          genomelistindex = 0;
          break;
        case 2:
          System.out.println("Choose DNA sequence:");
          System.out.println("1 - " + genomelist.size());
          input = sc.nextInt() - 1;
          stringinput = sc.nextLine();
          while (input > genomelist.size()) {
            System.out.println("Error input");
            System.out.println("Choose DNA sequence:");
            System.out.println("1 - " + genomelist.size());
            input = sc.nextInt() - 1;
            stringinput = sc.nextLine();
          }
          genomelistindex = input;
          break;
        case 3:
          System.out.println("Set substring:");
          substring = sc.nextLine();
          substring = substring.toUpperCase();
          break;
        case 4:
          SearchAlgorithm searcher = new CustomAlgorithm2();
          ArrayList<Integer> output;
          System.out.println("genome:" + genomelist.get(genomelistindex));
          output = searcher.search(genomelist.get(genomelistindex), substring, 0);
          System.out.println(output);
          SearchAlgorithm searcher2 = new KMPalgorithm();
          output = searcher2.search(genomelist.get(genomelistindex), substring, 0);
          System.out.println(output);
          if (output.isEmpty() == false) {
            displayFoundPositions(output);
          }
          break;
        case 5:
          stopped = true;
          break;
        default:
          System.out.println("Error reading input");
          break;
      }
    }
    // end timer
  }

  private static void displayFoundPositions(ArrayList<Integer> positions) {
    for (int i = 0; i < positions.size(); i++) {
      System.out.println("Found pattern " + "at position " + (positions.get(i) + 1));
    }
  }
}
