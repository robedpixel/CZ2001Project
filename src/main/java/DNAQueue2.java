import java.util.LinkedList;

public class DNAQueue2 extends LinkedList<Character> {
  private int totalcount = 0;
  final int AVALUE = 1;
  final int CVALUE = 2;
  final int TVALUE = 4;
  final int GVALUE = 8;
  final int NVALUE = 16;
  final int UVALUE = 32;

  //
  public int DNAPush(char in) {
    switch (in) {
      case 'A':
        this.push(in);
        totalcount += AVALUE;
        break;
      case 'C':
        this.push(in);
        totalcount += CVALUE;
        break;
      case 'T':
        this.push(in);
        totalcount += TVALUE;
        break;
      case 'G':
        this.push(in);
        totalcount += GVALUE;
        break;
      case 'N':
        this.push(in);
        totalcount += NVALUE;
        break;
      case 'U':
        this.push(in);
        totalcount += UVALUE;
        break;
      default:
        System.out.println("error inputing into queue!");
        System.out.println(in);
        return 1;
    }
    return 0;
  }

  public char DNAPop() {
    char pop = this.pollLast();
    switch (pop) {
      case 'A':
        totalcount -= AVALUE;
        break;
      case 'C':
        totalcount -= CVALUE;
        break;
      case 'T':
        totalcount -= TVALUE;
        break;
      case 'G':
        totalcount -= GVALUE;
        break;
      case 'N':
        totalcount -= NVALUE;
        break;
      case 'U':
        totalcount -= UVALUE;
        break;
      default:
        System.out.println("error removing from queue!");
        System.out.println(pop);
        return 1;
    }
    return pop;
  }

  public int getTotal() {
    return totalcount;
  }
}
