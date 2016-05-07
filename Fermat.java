/**
 * This program computes the closest numbers to satisfy
 * Fermat's Last Theorem.
 * 
 * https://en.wikipedia.org/wiki/Fermat%27s_Last_Theorem
 * 
 * The program reads input data from a file with conditions for the third power of 'n'.
 * The program then writes to a file for the closest numbers satisfying fermat's last theorem for this power. 
 * 
 * @author Adam Beck 
 */

//TODO: Add functionality for any power of 'n' in the future.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fermat {
	public static void main(String args[]){
		String inputFileName = args[0];
		String outputFileName = args[1];
		
		String[] initialConditions = scanFile(inputFileName, outputFileName);
		
		int a, b, c;
		double ratio; // Represents the best ratio found so far.
		
		/* Save and print out initial conditions */
		a = Integer.parseInt(initialConditions[0]);
		b = Integer.parseInt(initialConditions[1]);
		c = Integer.parseInt(initialConditions[2]);
		ratio = Double.parseDouble((initialConditions[3]));
		
		System.out.printf("Initial conditions: a=%d b=%d c=%d ratio=%f\n", a, b, c, ratio);
		System.out.println("Program starting. Better conditions will be printed if found.");
		
		/* Run the program */
		run(a, b, c, ratio, inputFileName, outputFileName);
	}
	
	/**
	 * Scans the input and output file, and returns the initial conditions for this program to run.
	 * @param fileName The name of the input file
	 * @return An array containing initial starting conditions.
	 */
	public static String[] scanFile(String inputName, String outputName){
		Scanner scan = null;
		Scanner scan2 = null;
		try {
			scan = new Scanner(new File(inputName));
			scan2 = new Scanner(new File(outputName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return new String[]{
				scan.next(),
				scan.next(),
				scan.next(),
				scan2.next(),

		};
	}
	
	/**
	 * Runs the program, prints out new conditions if found. Updates input and output files
	 * if new conditions are found.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param ratio
	 * @param intputName
	 * @param outputName
	 */
	public static void run(int a, int b, int c, double ratio, String intputName, String outputName){
		
	}
}
