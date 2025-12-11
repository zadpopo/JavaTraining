package oop1;


public class Truck extends Vehicle implements Refuelable {

    public Truck(int numberOfWheels, String brand) {
        super(numberOfWheels, brand);
    }

    @Override
    public void startEngine() {
        System.out.println("Truck: Starting heavy-duty engine... (" + toString() + ")");
    }

    @Override
    public void refuel() {
        System.out.println("Truck: Refueling with diesel at the depot. (" + toString() + ")");
    }
}