import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// coded by harish

// Assume length is substring to be x, length of string to be y.

public class BruteForce implements SearchAlgorithm {

  public ArrayList<Integer> search(String Genome, String substring, int substring_index) {
    ArrayList<Integer> output = new ArrayList<Integer>();
    LinkedList<Character> substringqueue = new LinkedList();
    LinkedList<Character> searchqueue = new LinkedList();

    // Fill substring queue with substring and searchqueue with initial values in Genome
    for (int i = 0; i < substring.length(); i++) {
      substringqueue.push(substring.charAt(i));
      searchqueue.push(Genome.charAt(i));
    } // ANALYSIS: time complexity = O(2x)

    // Search through Genome until end of Genome
    int loopcount = Genome.length() - substring.length() + 1;
    int looplimit = loopcount - 1;
    // ANALYSIS: time complexity = 3

    boolean stringfound = false;
    Iterator<Character> queueiterator;

    for (int i = 0; i < loopcount; i++) {
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

      // Shift the queue to the right by one
      if (i != looplimit) {
        searchqueue.pollLast();
        searchqueue.push(Genome.charAt((i + substring.length())));
      }
    }
    // loops x-y+1 times;
    // queue time complexity = O((x-y)*3)
    // worst case scenario = (x-y)(y)

    // worst case time complexity = yx+y^2+3x+3y-3

    return output;
  }
}
