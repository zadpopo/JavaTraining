package oop1;


public class MSExcel extends Program {

    public MSExcel(String name) {
        // <fill>
        this.setName(name);
    }

    @Override
    public void run() {
        String message = "Opening MS Excel...";
        // <fill>
        this.setIsRunning(true);
        System.out.println(message);
    }

    @Override
    public void stop() {
        String message = "Stopping MS Excel...";
        // <fill>
        this.setIsRunning(false);
        System.out.println(message);
    }
}
