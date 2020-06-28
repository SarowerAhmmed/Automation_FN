package com.sanity;

public class asdsdasd {
	private String name;
	
	public asdsdasd(String a) {
		
		this.name=a.split("eee")[0];
		System.out.println("Hi");
	}
	
	int floorNumber;
	
	

	public String getName() {
		return name;
	}
	//[\\$$##\\xA0]+"
public static void main(String[] args) {
	String s= "Bread$$##12.5$$##10";
	String b=s.split("[\\$$##\\xA0]+")[0];
	System.out.println(b);
}

}
