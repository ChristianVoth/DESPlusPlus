package mensaComponents;



import java.util.concurrent.*;

/**
 *
 */
public class StartMultithreading {


    public static void main(String [] args) throws InterruptedException, ExecutionException {

        List queueLenghts = new ArrayList();

        int numSimulations = 5;

        Mensa currentModel;

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        List<Future<Report>> listOfFutures = new ArrayList<Future<Report>>();

        System.out.println("Hauptthread gestartet");

        /*for(int i = 1; i < numSimulations + 1; i++) {
            Mensa mensa = new Mensa("Mensa Model" + i);
            Mensa.simulate(mensa);


        }
        */




        // create for every processor in your computer a thread
       for (int i = 1; i<= 1; i++) {
            Callable<Report> callableCustomThread = new CustomThread("Thread " + i);
            Future<Report> futureCounterResult = pool.submit(callableCustomThread);
            listOfFutures.add(futureCounterResult);
        }
       for (Future<Report> future : listOfFutures) {
           System.out.println(future.get());
       }
        pool.shutdown();

       double meanQueueLength = 0;
        for (Future<Report> future : listOfFutures) {
        }
        meanQueueLength = meanQueueLength / listOfFutures.size();

        System.out.println(meanQueueLength);
    }

}
