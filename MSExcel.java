package oop1;


public class MSExcel implements Executable {
    @Override
    public void run() {
        System.out.println("Opening MS Word...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MS Word...");
    }
}
