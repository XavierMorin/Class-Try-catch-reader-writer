import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**    Assignment 4
 * @author x_morin
*Albert<p>
*Written by: Xavier Morin 40077865<p>
*For COMP 249 section WW-Winter 2019<p>
*Due for 4/4/2019<p>
*Will create a sub-dictionary of all the words contained in the input file.
* <p>
*/
public class Albert {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter a name for the input file:");//input the file
		String name=input.nextLine();
		int entries=0;//count the number of word in the dictionary
		Scanner Reader=null;// to use later to read the input file
		
		try {
			Reader=new Scanner(new FileInputStream(name+".txt"));//Stream to the file
				
		}
		catch(FileNotFoundException e) {//errors
			System.out.println("Could not open file "+name+".txt"+" for reading. \n\n"
					+ "Please check that the file exists! Program will terminate after closing any opened files.");
			System.exit(0);
		}
		
		ArrayList Info=new ArrayList();//will contain all the words
		
		
		while(Reader.hasNext()) {//read the whole input file
			String token=Reader.next().toUpperCase();// take one element at a time separate by space and capitalized it
			
			
			if(token.length()==1 && (token.equalsIgnoreCase("a") || token.equalsIgnoreCase("i"))) {// will check for A and I
				if(Info.indexOf(token)==-1) {
				Info.add(token);
				entries++;}}
			
			else{
				if(token.length()>1 && !token.matches(".*\\d.*")) {// check if to eliminated words who contain digits
				
					if(token.endsWith("?")||token.endsWith(":")||token.endsWith(",")||token.endsWith(";")||token.endsWith("!")||token.endsWith("."))
						token=token.substring(0,token.length()-1);// remove all punctuation sign except '
					
					if(token.contains("’")) {// remove '
						token=token.substring(0,token.length()-2);}
					
					if(Info.indexOf(token)==-1) {// add this word if it is not already there
					Info.add(token);
					entries++;}
			}}	
		}
		
		String[] Sort=new String[Info.size()];//string array
		Info.toArray(Sort);// fill the array
		
		// sort the array A==>Z
		int size = Sort.length;

	      for(int i = 0; i<size-1; i++) {
	         for (int j = i+1; j<Sort.length; j++) {
	            if(Sort[i].compareTo(Sort[j])>0) {
	               String temp = Sort[i];
	               Sort[i] = Sort[j];
	               Sort[j] = temp;
	            }
	         }
	      }
		
	PrintWriter p=null;// prepare to write into a new txt file
  	   try {
  	    
  		   p=new PrintWriter( new FileOutputStream("Sub-Dictionary.txt",false));// new txt file
  	    }
  	   
  	   catch(Exception e) {
  		   System.out.println("No such file");//error
  		   
  	   }
  	   p.println("The document produced this sub-dictionary, which includes "+entries+" entries.");
  	   p.println(" ");
  	    int j=0;
		for(int i=0; i<26;i++) {// loops for all letters
			if(j>=Sort.length)// stop if no more word to check
				break;
			char character=(char)(i+65);// Letter to check for this iteration
			String test="^"+character+".*";//reggex test
			
			if(Sort[j].matches(test)) {//if there is at least one word ==>print the letter as a sub title
			if(i>0)
				p.println(" ");
			p.println(character);
			p.println("==");}
			
			while(true) {
				if(j>=Sort.length)//stop if no more word to check
					break;
				
				if(Sort[j].matches(test)) 	//print if the word start with the good letter
				p.println(Sort[j]);
				
				else {
					break;}
				
				j++;}
		}  
			  
		p.close();	   
			  
		 
		System.out.println("The sub-dictionary have been created successfully!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
