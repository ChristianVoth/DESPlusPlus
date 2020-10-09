/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package Multithreading;


import statistics.QueueReport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class Multithreading {

    /**
     *
     */
    private int numOfThreads;

    /**
     *
     */
    private int numOFSimulations;

    /**
     *
     */
    private int numOfFD;

    /**
     *
     */
    private int numOfCO;

    /**
     *
     */
    private String filename;

   /**
     *
     * @param nnumOfThreads
     * @param nnumOfSimulations
     * @param nnumOfFD
     * @param nnumOfCO
     * @param ffilename
     */
    public Multithreading(int nnumOfThreads, int nnumOfSimulations,
                          int nnumOfFD, int nnumOfCO, String ffilename) {
        this.numOfThreads = nnumOfThreads;
        this.numOFSimulations = nnumOfSimulations;
        this.numOfFD = nnumOfFD;
        this.numOfCO = nnumOfCO;
        this.filename = ffilename;
    }

    /**
     *
     */
    public void startMultithreading() throws
            ExecutionException, InterruptedException {

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        List<Future<ArrayList<ArrayList<QueueReport>>>> listOfFutures
                = new ArrayList<>();

        System.out.println("Hauptthread gestartet");

        // create for every processor in your computer a thread
       for (int i = 0; i < numOfThreads; i++) {
            Callable<ArrayList<ArrayList<QueueReport>>> callableCustomThread
                    = new CustomThread("Thread "
                    + (i + 1), numOFSimulations, numOfFD, numOfCO);
            Future<ArrayList<ArrayList<QueueReport>>> futureCounterResult
                    = pool.submit(callableCustomThread);
            listOfFutures.add(futureCounterResult);
        }

        pool.shutdown();

        int counter1 = 0;
        int counter2 = 0;


        //Threads --> Simulations --> QueueReports
        double meanQueueLength1 = 0;
        double meanQueueLength2 = 0;

        double medianQueueLength1 = 0;
        double medianQueueLength2 = 0;

        double maxQueueLength1 = 0;
        double maxQueueLength2 = 0;

        double meanWaitingTime1 = 0;
        double meanWaitingTime2 = 0;

        double medianWaitingTime1 = 0;
        double medianWaitingTime2 = 0;

        double maxWaitingTime1 = 0;
        double maxWaitingTime2 = 0;

        for (Future<ArrayList<ArrayList<QueueReport>>> future : listOfFutures) {
            for (int i = 0; i < future.get().size(); i++) {

                counter2++;
                for (int n = 0; n < future.get().get(i).size(); n++) {
                    System.out.println(future.get().get(i));
                    if (n == 0) {
                        meanQueueLength1 += future.get().get(i).
                                get(n).queueLengthReport.meanQueueLength;
                        medianQueueLength1 += future.get().get(i).
                                get(n).queueLengthReport.quantiles.median;
                        maxQueueLength1 += future.get().get(i).
                                get(n).queueLengthReport.maximumQueueLength;

                        meanWaitingTime1 += future.get().get(i).
                                get(n).waitingTimeReport.meanWaitingTime;
                        medianWaitingTime1 += future.get().get(i).
                                get(n).waitingTimeReport.quantiles.median;
                        maxWaitingTime1 += future.get().get(i).
                                get(n).waitingTimeReport.maximumWaitingTime;
                    }
                    if (n == 1) {
                        meanQueueLength2 += future.get().get(i).
                                get(n).queueLengthReport.meanQueueLength;
                        medianQueueLength2 += future.get().get(i).
                                get(n).queueLengthReport.quantiles.median;
                        maxQueueLength2 += future.get().get(i).
                                get(n).queueLengthReport.maximumQueueLength;

                        meanWaitingTime2 += future.get().get(i).
                                get(n).waitingTimeReport.meanWaitingTime;
                        medianWaitingTime2 += future.get().get(i).
                                get(n).waitingTimeReport.quantiles.median;
                        maxWaitingTime2 += future.get().get(i).
                                get(n).waitingTimeReport.maximumWaitingTime;
                    }

                    System.out.println(meanWaitingTime1);
                    System.out.println(meanWaitingTime2);
                counter1++;
            }
        }
        }

        counter1 = counter2;

        meanQueueLength1 = meanQueueLength1 / counter1;
        meanQueueLength2 = meanQueueLength2 / counter1;

        medianQueueLength1 = medianQueueLength1 / counter1;
        medianQueueLength2 = medianQueueLength2 / counter1;

        maxQueueLength1 = maxQueueLength1 / counter1;
        maxQueueLength2 = maxQueueLength2 / counter1;

        meanWaitingTime1 = meanWaitingTime1 / counter1;
        meanWaitingTime2 = meanWaitingTime2 / counter1;

        medianWaitingTime1 = medianWaitingTime1 / counter1;
        medianWaitingTime2 = medianWaitingTime2 / counter1;

        maxWaitingTime1 = maxWaitingTime1 / counter1;
        maxWaitingTime2 = maxWaitingTime2 / counter1;



        System.out.println("\n" + "Mean Queue1 Length " + meanQueueLength1);
        System.out.println("Mean Queue2 Length " + meanQueueLength2);
        System.out.println("Median Queue1 Length " + medianQueueLength1);
        System.out.println("Median Queue2 Length " + medianQueueLength2);
        System.out.println("Max Queue1 Length " + maxQueueLength1);
        System.out.println("Max Queue2 Length " + maxQueueLength2);
        System.out.println("Mean Waiting1 Time " + meanWaitingTime1);
        System.out.println("Mean Waiting2 Time " + meanWaitingTime2);
        System.out.println("Median Waiting1 Time " + medianWaitingTime1);
        System.out.println("Median Waiting2 Time " + medianWaitingTime2);
        System.out.println("Max Waiting1 Time " + maxWaitingTime1);
        System.out.println("Max Waiting2 Time " + maxWaitingTime2);

        System.out.println(counter1);
        System.out.println(counter2);
    }

}
