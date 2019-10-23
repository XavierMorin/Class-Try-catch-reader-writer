import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**    Assignment 4
 * @author x_morin
*CellListUtilization/driver<p>
*Written by: Xavier Morin 40077865<p>
*For COMP 249 section WW-Winter 2019<p>
*Due for 4/4/2019<p>
*Driver<p>
* <p>
*/
public class CellListUtilization {

	public static void main(String[] args) {
		
		CellList CL1=new CellList();// new cell lists
		CellList CL2=new CellList();
		
Scanner Reader=null;// to use later
		
		try {
			Reader=new Scanner(new FileInputStream("Cell_Info.txt"));//Stream to the file
				
		}
		catch(FileNotFoundException e) {//errors
			System.out.println("Could not open file Cell_Info.txt"+" for reading. \n\n"
					+ "Please check that the file exists! Program will terminate after closing any opened files.");
			System.exit(0);
		}
		
		while(Reader.hasNext()) {//read file and put it in CL1
			 long serialNum=Reader.nextLong();
			 String brand=Reader.next();
			 double price=Reader.nextDouble();
			 int year=Reader.nextInt();
			 
			 CellPhone phone=new CellPhone(serialNum,brand,year,price);
			 CL1.addToStart(phone);
			
		}
		
		CL1.showContents();

		System.out.print("\n");
		Scanner input=new Scanner(System.in);
		
		while(true) {
		System.out.print("\nPlease enter a serial number (-1 to exit): ");
		int num=input.nextInt();
		if(num==-1)
			break;
		if(CL1.contains(num))
			System.out.println("There is a CellPhone with the serial number: "+num);
		else 
			System.out.println("There isn't any CellPhone with the serial number: "+num);
		
		}
		CellList CL3=new CellList(CL1);
		System.out.println("\nAre CL1 and CL3 equals: "+CL1.equals(CL3));
		System.out.println("\nCL1.DeleteFromStart()");
		CL1.deleteFromStart();
		CL1.showContents();
		System.out.println("\n\nCL1.DeleteFromIndex(3)");
		CL1.deleteFromIndex(3);
		CL1.showContents();
		CellPhone phone=new CellPhone(4464646,"Samsung",2016,199.99);
		
		System.out.println("\n\nCL1.InsertAtIndex(phone,7)==>"+phone);
		CL1.insertAtIndex(phone, 7);
		CL1.showContents();
		System.out.println("\n\n");
		CL3.showContents();
		System.out.println("\n\nAre CL1 and CL3 equals: "+CL1.equals(CL3));
		System.out.println("\nCL1.deletFromImdex(LastElement)");
		
		CL1.deleteFromIndex(CL1.getSize()-1);
		CL1.showContents();
		
		
		
		
	}
	
	
	
	
	

}
