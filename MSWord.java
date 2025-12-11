package oop1;



public class MSWord extends Program {

    public MSWord(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println("Opening MS Word...");
        // <fill>
        this.setIsRunning(true);
    }

    @Override
    public void stop() {
        System.out.println("Stopping MS Word...");
        // <fill>
        this.setIsRunning(false);
    }
}
