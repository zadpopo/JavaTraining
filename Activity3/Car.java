package oop1;

public class Car {
     String make;
     String color;
     String yearModel;

    // No-argument constructor
    public Car() {
        this.make = "Unknown";
        this.color = "Unknown";
        this.yearModel = "Unknown";
    }

    // Parameterized constructor
    public Car(String make, String color, String yearModel) {
        this.make = make;
        this.color = color;
        this.yearModel = yearModel;
    }


    // display info
    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Color: " + color);
        System.out.println("Year Model: " + yearModel);
    }
}
