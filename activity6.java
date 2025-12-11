package oop1;

public class activity6 {

    public static void main(String[] args) {
       
        Car car = new Car(4, "Toyota");
        Truck truck = new Truck(6, "Hyundai");

       
        car.startEngine();
        car.refuel();

        truck.startEngine();
        truck.refuel();

      
        destroyVehicle(car);
        destroyVehicle(truck);
    }


    public static void destroyVehicle(Vehicle vehicle) {
        System.out.println("Dispatching destroy operation for: " + vehicle.toString());
        vehicle.destroy();
        System.out.println();
    }
}




