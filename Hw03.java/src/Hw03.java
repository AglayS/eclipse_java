import java.util.*;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;



//Aglay Saenz, due May 2, 2021, COP3503

public class Hw03 {
	
	
	  
	public static int UCFxram (String input, int len) {

	int randVal1 = 0xbcde98ef; //arbitrary value
	int randVal2 = 0x7890face; //arbitrary value
	int hashVal = 0xfa01bc96; //start seed value 
	int roundedEnd = len & 0xfffffffc; //array d gets 4 byte blocks
	int tempData = 0; 

	byte[] d = null;
	
	
	try { //try for getting bytes
		
		d = input.getBytes("US-ASCII");
	  
	} 
	
	catch (UnsupportedEncodingException e) { //catch for failure
		
		System.out.println("Non-ASCII characters in input, please try again.");
	
		e.printStackTrace();
	
	return 0;
	
	}
	
	  
	//loop to multiply and rotate in one go
	for (int i = 0 ; i < roundedEnd ; i = i + 4) { //get temps and has values
	  
		tempData = (d[i] & 0xff) | ((d[i + 1] & 0xff) << 8) | ((d[i + 2] & 0xFF) << 16) | ((d[i + 3] << 24)); 
		
		tempData = tempData * randVal1; //multiply
		
		tempData = Integer.rotateLeft(tempData, 12); //rotate left 12 bits
		
		tempData = tempData * randVal2; //multiply
	
		hashVal = hashVal ^ tempData; //hashval XOR tempData
		
		hashVal = Integer.rotateLeft(hashVal, 13); //rotate left 13 bits
		
		hashVal = hashVal * 5 + 0x46b6456e;

	}

	//following will collect orphan input characters  
	
	tempData = 0;
	
	int length = len;
	
	if ((length & 0x03) == 3) {
		
		tempData = ( d[ roundedEnd + 2] & 0xFF) << 16;
	
		length = length - 1;
	
	}
	
	if ((length & 0x03) == 2) {
		
		tempData |= ( d[ roundedEnd + 1] & 0xff) << 8;
		
		length = length -1;
	
	}
	
	if ((length & 0x03) == 1) {
		
		tempData |= (d[roundedEnd] & 0xff);
	
		tempData = tempData * randVal1; //more multiply
	
		tempData = Integer.rotateLeft(tempData, 14); //rotate left 14 bits
	
		tempData = tempData * randVal2; //more multiply
		
		hashVal = hashVal ^ tempData; //hashtag XOR tempData
	
	}
	  
	
	hashVal = hashVal ^ length; //XOR
	
	hashVal = hashVal & 0xb6acbe58; //AND
	
	hashVal = hashVal ^ hashVal >>> 13 ; //goes to 13
	
	hashVal = hashVal * 0x53EA2B2C; //another arbitrary value

	hashVal = hashVal ^ hashVal >>> 16; //goes to 16
	

	return hashVal; //finally return the 32 bit int hash

}
	
public void complexityIndicator () {
		
	System.err.println("ag127018; 2.5; 8");
	
	//a lot of the pseudocode was given, sooooo
		
}



public static void main (String[] args) {
	  

	if (args.length == 1) { //if exists
		
		String string;
	  
		try { //get input file
			
			File file = new File(args[0]);
			
			Scanner scan = new Scanner(file);
			
			int hashValue = 0;
			
			while (scan.hasNextLine()) {
				
				string = scan.nextLine();
				
					string = string.replaceAll("\n", "").replaceAll("\r", "");
					
					hashValue = UCFxram(string, string.length());
					
					System.out.format("%10x:%s\n", hashValue, string);
	
				}
			
			System.out.println("Input file processed");

	} 
		
	catch (FileNotFoundException e) { //if it fails
		
		System.out.println("Unable to read the file " + args[0]);
	
		}
		
	} 
	
}

	

} //end
