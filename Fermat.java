/**
 * This program computes the closest numbers to satisfy Fermat's Last Theorem.
 * 
 * https://en.wikipedia.org/wiki/Fermat%27s_Last_Theorem
 * 
 * The program reads input data from a file with conditions for the third power of 'n'.
 * The program then writes to a file for the closest numbers satisfying fermat's last theorem for this power. 
 * 
 * @author Adam Beck 
 */

//TODO: Add functionality for any power of 'n' in the future.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fermat {
	public static void main(String args[]) throws IOException{
		String inputFileName = args[0];
		String outputFileName = args[1];
		
		String[] initialConditions = scanFile(inputFileName, outputFileName);
		
		double a, b, c;
		double ratio; // Represents the best ratio found so far.
		
		/* Save and print out initial conditions */
		a = Double.parseDouble(initialConditions[0]);
		b = Double.parseDouble(initialConditions[1]);
		c = Double.parseDouble(initialConditions[2]);
		ratio = Double.parseDouble((initialConditions[3]));
		
		System.out.printf("Initial conditions: a=%f b=%f c=%f ratio=%f\n", a, b, c, ratio);
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
	 * @throws IOException 
	 */
	public static void run(double a, double b, double c, double ratio, String inputName, String outputName) throws IOException{
		
		while(true){
			for (; ; b++){
				for (; ; c++){
					//System.out.println("a=" +a+ "b=" +b+ "c=" +c);
					/* Update conditions if neccessary */
					if (Math.abs(1 - (double)c*c*c / (double)(a*a*a + b*b*b)) <
							Math.abs((double)1 - ratio)){
						
						/* Delete old file, update with new values */
						try {
							 BufferedWriter writer = new BufferedWriter(new FileWriter(inputName));
							 writer.write(a + "\n");
							 writer.write(b + "\n");
							 writer.write(c + "\n");
							 writer.close();
							 
							 ratio = (double)c*c*c / (double)(a*a*a + b*b*b);
							 writer = new BufferedWriter(new FileWriter(outputName));
							 writer.write(ratio + "");
							 writer.close();
							 
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.printf("New conditions: a=%f b=%f c=%f ratio=%f\n", a, b, c, ratio);
					}
					
					if (a*a*a + b*b*b < c*c*c){
						break;
					}
					
				}
				
				while (a*a*a + b*b*b < c*c*c){
					a++;
				}
			}
			
		}
	}
	
	public static double getRatio(String outputName) throws FileNotFoundException{
		Scanner scan2 = new Scanner(new File(outputName));
		return Double.parseDouble(scan2.next());
	}
}
