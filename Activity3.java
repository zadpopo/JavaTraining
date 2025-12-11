package oop1;

public class Activity3 {
    public static void main(String[] args) {
        // Using no-argument constructor
        Car vios = new Car();
        vios.make = "Toyota";
        vios.color ="Silver";
        vios.yearModel ="2018";
        System.out.println("Vios (no-argument constructor):");
        
        vios.displayInfo();
        
        
        // Using parameterized constructor
        Car corolla = new Car("Toyota", "Emotional Red", "2024");
        System.out.println("\nCorolla (parameterized constructor):");
        
    
        corolla.displayInfo();
    }
}
