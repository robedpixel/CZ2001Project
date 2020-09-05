import java.util.ArrayList;


//coded by win

public class ThreadsFunction {

  public static void main(String[] args) {}

  // SpilitStringFunction to be carried out in this Run_Threads Function
  // Take Genome and subString as inputs.
  public static void Run_Threads(String Genome, String substring) {
    StringFragment[] output = new StringFragment();
    SpiltStringFunction splitFunction = new SpiltStringFunction();
    StringFragment[] result_returned = split(Genome, subString);

    Thread_One thread1 = new ThreadOne();
    Thread_Two thread2 = new ThreadTwo();

    // Initilisation
    Thread1.init(genome, result_returned);
    Thread2.init(genome, result_returned);

    // This thread1.start() and thread2.start will execute at the same time. These function will
    // trigger the run() function in both thread1 class and thread2 class.
    thread1.start(); // Both will execute concurrently
    thread2.start(); // Both will execute concurrently
  }
}

// Thread one class
class Thread_One extends Thread {

  String genome;
  String subString;
  int subStringIndex;

  // Initialisation
  public void init(String genome, StringFragment[] split_output) {
    this.genome = genome;
    this.subString = split_output[0].substring;
    this.subStringIndex = split_output[0].substringIndex;
  }

  // This function will be triggered by the thread1.start()
  public void run() {
    ArrayList<Integer> output1;
    CustomAlgorithm2 CustAlgo2 = new CustomAlgorithm2();
    output = CustAlgo2.search(Genome, subString, substring_index);
    System.out.println(output1);
  }
}
// Thread two class
class Thread_two extends Thread {

  String genome;
  String subString;
  int subStringIndex;

  // Initialisation
  public void init(String genome, StringFragment[] split_output) {
    this.genome = genome;
    this.subString = split_output[1].substring;
    this.subStringIndex = split_output[1].substringIndex;
  }

  // This function will be triggered by the thread1.start()
  public void run() {
    ArrayList<Integer> output1;
    CustomAlgorithm2 CustAlgo2 = new CustomAlgorithm2();
    output = CustAlgo2.search(Genome, subString, substring_index);
    System.out.println(output1);
  }
}
