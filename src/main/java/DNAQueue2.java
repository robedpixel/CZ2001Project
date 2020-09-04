import java.util.LinkedList;

public class DNAQueue2 extends LinkedList<Character> {
  private int totalcount = 0;
  final int AVALUE = 1;
  final int CVALUE = 2;
  final int TVALUE = 4;
  final int GVALUE = 8;

  public int DNAPush(char in) {
    switch (in) {
      case 'A':
        this.push(in);
        totalcount = totalcount + AVALUE;
        break;
      case 'C':
        this.push(in);
        totalcount = totalcount + CVALUE;
        break;
      case 'T':
        this.push(in);
        totalcount = totalcount + TVALUE;
        break;
      case 'G':
        this.push(in);
        totalcount = totalcount + GVALUE;
        break;
      default:
        System.out.println("error inputing into queue!");
        return 1;
    }
    return 0;
  }

  public char DNAPop() {
    char pop = this.pop();
    switch (pop) {
      case 'A':
        totalcount = totalcount - AVALUE;
        break;
      case 'C':
        totalcount = totalcount - CVALUE;
        break;
      case 'T':
        totalcount = totalcount - TVALUE;
        break;
      case 'G':
        totalcount = totalcount + GVALUE;
        break;
    }
    return pop;
  }

  public int getTotal() {
    return totalcount;
  }
}
