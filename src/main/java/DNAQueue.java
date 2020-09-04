import java.util.LinkedList;

public class DNAQueue extends LinkedList<Character> {
  int Acount = 0;
  int Ccount = 0;
  int Tcount = 0;
  int Gcount = 0;

  public int DNAPush(char in) {
    switch (in) {
      case 'A':
        this.push(in);
        Acount++;
        break;
      case 'C':
        this.push(in);
        Ccount++;
        break;
      case 'T':
        this.push(in);
        Tcount++;
        break;
      case 'G':
        this.push(in);
        Gcount++;
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
        Acount--;
        break;
      case 'C':
        Ccount--;
        break;
      case 'T':
        Tcount--;
        break;
      case 'G':
        Gcount--;
        break;
    }
    return pop;
  }
}
