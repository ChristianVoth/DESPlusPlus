package mensaComponents;

public class Thread {

    public static void main(String [] args) throws InterruptedException {

        int processors = Runtime.getRuntime().availableProcessors();
        int zahl = 2;

        System.out.println("Hauptthread gestartet");
        Mensa.simulate();
        /*for(int i = 1; i <= processors; i++) {
            CustomThread thread = new CustomThread("Thread " + i);
            thread.start();

    }*/
    }
}
