package oop1;

public class Book {
	String author =null;
	int    year = 0;
	
	
    void speak(){
    	author = "Rizal";
		System.out.println("The Author is " + author);
	}// end of void speak
	
	void find(){
		year = 1900;
		System.out.println("Year " + year);
	}// end of void find
}
