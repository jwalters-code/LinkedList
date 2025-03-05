/*
Jade Walters
CSCI 2251
Assignment 3: Hurricane Data
Purpose: Practive working with classes and objects
Sources: --I referenced some of my coding projects from 
CS 1152 for array lists and classes.
--I used Geeks for geeks for help with String split() method
link: https://www.geeksforgeeks.org/split-string-java-examples/.
--I used Geeks for geeks for help with converting String to int
link: https://www.geeksforgeeks.org/how-to-convert-string-to-int-in-java/
--I used Oracle's website to see how to catch more than one error in one 
catch statement
link:
https://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;  //for output to file
import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		//create array list for hurrican row data
		ArrayList<HurricaneRowData> dataArray = new ArrayList<HurricaneRowData>();
		
		try {
			
			//read in from file
			File hurricaneData = new File(args[0]);
			Scanner readFile = new Scanner(hurricaneData);
			
			//strip first line, headers
			readFile.nextLine();
			
			while(readFile.hasNext()) {
				
				//read each line to a String variable
				String lineData = readFile.nextLine();
				
				//create array to hold split data
				//source: 
				//https://www.geeksforgeeks.org/split-string-java-examples/
				String[] tempArray = lineData.split(",");
				
				/*
				//FOR TESTING
				System.out.println(lineData);
				for(int i=0; i<tempArray.length; i++) {
					System.out.println(tempArray[i]);
				}
				*/
				
				//convert data from Strings to integers
				//source: 
				//https://www.geeksforgeeks.org/how-to-convert-string-to-int-in-java/
				int[] numArray = new int[tempArray.length];
				for(int i=0; i<tempArray.length; i++) {
					numArray[i] = Integer.parseInt(tempArray[i]);
				}
				
				//create hurricaneRowData objects
				HurricaneRowData hurricane = new HurricaneRowData
					(numArray[0], numArray[1], numArray[2], numArray[3], numArray[4]);
				
				//add to hurricane object to data array list
				dataArray.add(hurricane);
			}
			
			//close scanner
			readFile.close();
			
		//source: 
		//https://docs.oracle.com/javase/7/docs/technotes/guides
		///language/catch-multiple.html	
		} catch(IOException|ArrayIndexOutOfBoundsException e) { 
		
			//print exception message and exit
			System.out.println("There was an IO Exception.");
			System.exit(1);
		}
		
		/*
		//FOR TESTING
		for(int i=0; i<dataArray.size(); i++) {
			System.out.println(dataArray.get(i));
		}
		*/
	
		//call maxYear method
		int maxAceYear = maxYear(dataArray);
		
		//create variable for max ACE value
		int maxIndex = 0;
		
		//find maxAceValue
		for(int i=0; i<dataArray.size(); i++) {
			if(dataArray.get(i).getYear() == maxAceYear) {
				maxIndex = i;
			}
		}

		//print year and ACE from maximal ACE year
		System.out.print(dataArray.get(maxIndex).toString());
		
		//Output to text file
		try {
			
			//create filewriter and add data
			FileWriter writer = new FileWriter("maxAceOutput.txt");
			writer.write(dataArray.get(maxIndex).toString());
			
			//close filewriter
			writer.close();
			
		} catch(IOException e) {
			
			//print message and exit
			System.out.println("There was an IO Exception");
			System.exit(2);
		}
	}
	
	//method returns the year in which the ACE index was maximal
	private static int maxYear (ArrayList<HurricaneRowData> dataArrayList) {
		//create maxAce variable, set equal to first entry
		int maxAce = dataArrayList.get(0).getAceIndex();
		int aceIndex = 0; //track index of max
		
		//check for higher ace indexes and update maxAce as needed
		for(int i=1; i<dataArrayList.size(); i++) {
			if(dataArrayList.get(i).getAceIndex() > maxAce) {
				maxAce = dataArrayList.get(i).getAceIndex();
				aceIndex = i;
			}
			
			/*
			//FOR TESTING
			System.out.println(maxAce);
			System.out.println(aceIndex);
			*/
		}
		
		//retrieve year of maxAce and return year
		int maxYear = dataArrayList.get(aceIndex).getYear();
		return maxYear;
	}
}
