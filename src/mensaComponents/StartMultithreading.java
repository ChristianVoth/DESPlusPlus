package mensaComponents;

/**
 *
 */
public class StartMultithreading {

    public static void main(String [] args) throws InterruptedException {

        int processors = Runtime.getRuntime().availableProcessors();

        System.out.println("Hauptthread gestartet");
        Mensa.simulate();

        // create for every processor in your computer a thread
       /* for(int i = 1; i <= processors; i++) {
            // create a new thread with a name
            CustomThread thread = new CustomThread("Thread " + i);
            // start this thread
            thread.start();
        }*/
    }
}
