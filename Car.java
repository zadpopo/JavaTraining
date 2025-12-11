package oop1;


public class Car extends Vehicle implements Refuelable {

    public Car(int numberOfWheels, String brand) {
        super(numberOfWheels, brand);
    }

    @Override
    public void startEngine() {
        System.out.println("Car: Starting engine... (" + toString() + ")");
    }

    @Override
    public void refuel() {
        System.out.println("Car: Refueling with gasoline at the pump. (" + toString() + ")");
    }
}
