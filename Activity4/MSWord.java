package oop1;


public class MSWord implements Executable {
    @Override
    public void run() {
        System.out.println("Opening MS Excel...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MS Excel...");
    }
}
