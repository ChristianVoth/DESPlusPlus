package mensaComponents;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 *
 */
public class StartMultithreading {



    public static void main(String [] args) throws InterruptedException, ExecutionException {



        int numSimulations = 5;

        Mensa currentModel;

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        List<Future<ArrayList<Report>>> listOfFutures = new ArrayList<>();

        System.out.println("Hauptthread gestartet");

        /*for(int i = 1; i < numSimulations + 1; i++) {
            Mensa mensa = new Mensa("Mensa Model" + i);
            Mensa.simulate(mensa);


        }
        */




        // create for every processor in your computer a thread
       for (int i = 0; i<= 4; i++) {
            Callable<ArrayList<Report>> callableCustomThread = new CustomThread("Thread " + i);
            Future<ArrayList<Report>> futureCounterResult = pool.submit(callableCustomThread);
            listOfFutures.add(futureCounterResult);
        }
       for (Future<ArrayList<Report>> future : listOfFutures) {
           System.out.println(future.get());
       }
        pool.shutdown();

       double meanFDQueueLength = 0;
       double meanFDWaitingTime = 0;
       int sizeOfWholeReport = 0;

        for (Future<ArrayList<Report>> future : listOfFutures) {
            for(int i = 0; i < future.get().size(); i++){
                meanFDQueueLength += future.get().get(i).meanReport.studentFDQueue_meanLength;
                meanFDWaitingTime += future.get().get(i).meanReport.studentFDQueue_meanWaitingTime;
                sizeOfWholeReport += future.get().size();
            }
        }


        meanFDQueueLength = meanFDQueueLength / sizeOfWholeReport;
        meanFDWaitingTime = meanFDWaitingTime/ sizeOfWholeReport;

        System.out.println(meanFDQueueLength);
        System.out.println(meanFDWaitingTime);
        System.out.println(sizeOfWholeReport);
    }

}
