import java.util.ArrayList;

// coded by win

public class ThreadsFunction {

  public static void main(String[] args) {}

  // Take Genome and subString as inputs.
  public static void Run_Threads(String genome, String substring, ArrayList[] output) {
    StringFragment[] split_output;
    split_output = SpiltStringFunction.split(genome, substring);
    ArrayList<Integer> threadoutput1 = new ArrayList<Integer>();
    ArrayList<Integer> threadoutput2 = new ArrayList<Integer>();
    Threads thread1 = new Threads(substring, split_output[0], threadoutput1);
    Threads thread2 = new Threads(substring, split_output[1], threadoutput2);

    // This thread1.start() and thread2.start will execute at the same time. These functions will
    // trigger the run() function in the class Thread().
    thread1.start(); // Both will execute concurrently
    thread2.start(); // Both will execute concurrently
    try {
      thread1.join();
      thread2.join();
    } catch (Exception e) {
      System.out.println("THREAD ERROR");
    }
    output[0] = threadoutput1;
    output[1] = threadoutput2;
  }
}

// Thread one class
class Threads extends Thread {

  String genome;
  String substring;
  int genomeindex;
  ArrayList<Integer> output;
  // Initialisation
  Threads(String substring, StringFragment genome, ArrayList<Integer> threadoutput) {
    this.genome = genome.substring;
    this.substring = substring;
    this.genomeindex = genome.substringindex;
    this.output = threadoutput;
  }

  // This function will be triggered by the thread1.start()

  public void run() {
    CustomAlgorithm2 CustAlgo2 = new CustomAlgorithm2();
    output.addAll(CustAlgo2.search(genome, substring, genomeindex));
    // System.out.println("Thread output:" + output);
  }
}
