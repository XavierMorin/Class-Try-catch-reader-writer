import java.util.Scanner;
/**    Assignment 4
 * @author x_morin
*CellPhone<p>
*Written by: Xavier Morin 40077865<p>
*For COMP 249 section WW-Winter 2019<p>
*Due for 4/4/2019<p>
*CellPhone Object
* <p>
*/

public class CellPhone {

	
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	
	/**
	   * Constructor
	   * @param serialNum
	   * @param brand
	   * @param year
	   * @param price
	   */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	
//	
	
	
	/**
	   * Copy Constructor
	   * @param CP
	   * @param SNum
	   */
	public CellPhone(CellPhone CP, long SNum) {
		this.serialNum = SNum;
		this.brand = CP.brand;
		this.year = CP.year;
		this.price = CP.price;
	}

	/**
	   * Clone
	   * @return CP
	   */
	public CellPhone clone() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter a new Serial Number: ");
		long SNum=input.nextLong();
		CellPhone CP=new CellPhone(this,SNum);
		return CP;
	}

	/**
	   * Copy Constructor
	   * @param obj
	   * @Override
	   */
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		
		if (year != other.year)
			return false;
		return true;
	}





	
	@Override
	public String toString() {
		return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
	}






	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
