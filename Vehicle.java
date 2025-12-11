package oop1;


public abstract class Vehicle {

    private int numberOfWheels;
    private String brand;

    public Vehicle(int numberOfWheels, String brand) {
        this.numberOfWheels = numberOfWheels;
        this.brand = brand;
    }

    // Abstract method
    public abstract void startEngine();

    // Concrete method
    public void destroy() {
        System.out.println(getBrand() + " vehicle is being destroyed...");
        System.out.println("All parts salvaged. Vehicle record archived.");
    }

    // Getters / Setters
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%s %d wheels", brand, numberOfWheels);
    }
}
