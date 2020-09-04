import java.util.LinkedList;
import java.util.Scanner;

//Coded by Nick

public class SpiltStringFunction {
	public static StringFragment[] split(String Genome, String substring) {
		
		//String Genome = "adajsdalsjdlasjdlkasjdijfoewjflksnflksf";
		//String substring = "abvcsdfg";
		
		//find length of substring and genome
		StringFragment[] output = new StringFragment[2];
		StringFragment first_half = new StringFragment();
		StringFragment second_half = new StringFragment();
		int substring_length = substring.length();
		int genome_length = Genome.length();
		
		//midpoint of genome
		int genome_midpoint = (genome_length - 1) / 2; 
		
		//find midpoint + overlapping in order to ensure substring missed out at midpoint
		int first_index = genome_midpoint + substring_length; 
		
		//spilt string 
		first_half.substring = Genome.substring(0, first_index);
		first_half.substringindex = 0;
		output[0]=first_half;
		second_half.substring = Genome.substring(genome_midpoint, (genome_length-1));
		second_half.substringindex = genome_midpoint;
		output[1] = second_half;
		//System.out.println(first_half);
		//System.out.println(first_second);
		
		return output;
	}
}
