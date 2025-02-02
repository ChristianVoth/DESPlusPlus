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


import core.LogHandler;
import statistics.QueueReport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 */
public class Multithreading {

    /**
     * A variable to store the number of Threads.
     */
    private int numOfThreads;

    /**
     * A variable to store number of simulations.
     */
    private int numOfSimulations;

    /**
     * A variable to store the number of food distributions.
     */
    private int numOfFD;

    /**
     * A variable to store the number of checkouts.
     */
    private int numOfCO;

    /**
     * A variable to store the integer value of the student generator.
     */
    private int studentGenerator;

    /**
     * A variable to store the number of staff.
     */
    private int numOfStaff;

    /**
     * Create a FinalReport object to use.
     */
    private FinalReport finalReport;

    LogHandler myLog = new LogHandler();

    /**
     * Multithreading Constructor.
     * @param numOfThreads
     *      int : The number of Threads
     * @param numOfSimulations
     *      int : The number of Simulations
     * @param numOfStaff
     *      int : The number of staff
     * @param studentGenerator
     *      int : The int value of the student generator
     */
    public Multithreading(int numOfThreads, int numOfSimulations, int numOfStaff, int studentGenerator) {
        this.numOfThreads = numOfThreads;
        this.numOfSimulations = numOfSimulations;
        this.numOfStaff = numOfStaff;
        this.studentGenerator = studentGenerator;
    }

    /**
     * Multithreading Constructor.
     * @param nnumOfThreads
     *      int : The number of Threads
     * @param nnumOfSimulations
     *      int : The number of Simulations
     * @param nnumOfFD
     *      int : The number of food distributions
     * @param nnumOfCO
     *      int : The number of checkouts
     * @param numOfStaff
     *      int : The number if staff
     * @param studentGenerator
     *      int : The int value of the student generator
     */
    public Multithreading(int nnumOfThreads, int nnumOfSimulations,
                          int nnumOfFD, int nnumOfCO, int numOfStaff, int studentGenerator) {
        this.numOfThreads = nnumOfThreads;
        this.numOfSimulations = nnumOfSimulations;
        this.numOfFD = nnumOfFD;
        this.numOfCO = nnumOfCO;
        this.numOfStaff = numOfStaff;
        this.studentGenerator = studentGenerator;
    }

    /**
     * Get Method for final report.
     * @return a FinalReport object
     */
    public FinalReport getFinalReport() {
        return finalReport;
    }

    /**
     * In this method multithreading can be started.
     */
    public void startMultithreading() throws
            ExecutionException, InterruptedException {

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

        List tallyList1;
        List tallyList2;

        List accumulateList1;
        List accumulateList2;

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        List<Future<ArrayList<ArrayList<QueueReport>>>> listOfFutures
                = new ArrayList<>();

        System.out.println("Hauptthread gestartet\n");

        switch (studentGenerator) {
            case 1:
                for (int i = 0; i < numOfThreads; i++) {
                    Callable<ArrayList<ArrayList<QueueReport>>> callableCustomThread
                            = new CustomThread("Thread "
                            + (i + 1), numOfSimulations, numOfStaff, studentGenerator);
                    Future<ArrayList<ArrayList<QueueReport>>> futureCounterResult
                            = pool.submit(callableCustomThread);
                    listOfFutures.add(futureCounterResult);
                }

                pool.shutdown();

                for (Future<ArrayList<ArrayList<QueueReport>>> future : listOfFutures) {
                    for (int i = 0; i < future.get().size(); i++) {

                        counter2++;
                        for (int n = 0; n < future.get().get(i).size(); n++) {
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

                meanWaitingTime1 = Math.abs(meanWaitingTime1) / counter1;
                meanWaitingTime2 = Math.abs(meanWaitingTime2) / counter1;

                medianWaitingTime1 = Math.abs(medianWaitingTime1) / counter1;
                medianWaitingTime2 = Math.abs(medianWaitingTime2) / counter1;

                maxWaitingTime1 = Math.abs(maxWaitingTime1) / counter1;
                maxWaitingTime2 = Math.abs(maxWaitingTime2) / counter1;

                finalReport = new FinalReport(meanQueueLength1, meanQueueLength2, medianQueueLength1, medianQueueLength2,
                        maxQueueLength1, maxQueueLength2, meanWaitingTime1, meanWaitingTime2, medianWaitingTime1,
                        medianWaitingTime2, maxWaitingTime1, maxWaitingTime2);

                System.out.println("\n" + "Mean Queue Length Food Distribution: " + meanQueueLength1);
                System.out.println("Mean Queue Length Checkout: " + meanQueueLength2);
                System.out.println("Median Queue Length Food Distribution: " + medianQueueLength1);
                System.out.println("Median Queue Length Checkout: " + medianQueueLength2);
                System.out.println("Max Queue Length Food Distribution: " + maxQueueLength1);
                System.out.println("Max Queue Length Checkout: " + maxQueueLength2);
                System.out.println("Mean Waiting Time Food Distribution: " + meanWaitingTime1);
                System.out.println("Mean Waiting Time Checkout: " + meanWaitingTime2);
                System.out.println("Median Waiting Time Food Distribution: " + medianWaitingTime1);
                System.out.println("Median Waiting Time Checkout: " + medianWaitingTime2);
                System.out.println("Max Waiting Time Food Distribution: " + maxWaitingTime1);
                System.out.println("Max Waiting Time Checkout: " + maxWaitingTime2);

                break;
            case 2:

                for (int i = 0; i < numOfThreads; i++) {
                    Callable<ArrayList<ArrayList<QueueReport>>> callableCustomThread
                            = new CustomThread("Thread "
                            + (i + 1), numOfSimulations, numOfFD, numOfCO, numOfStaff, studentGenerator);
                    Future<ArrayList<ArrayList<QueueReport>>> futureCounterResult
                            = pool.submit(callableCustomThread);
                    listOfFutures.add(futureCounterResult);
                }

                pool.shutdown();


                for (Future<ArrayList<ArrayList<QueueReport>>> future : listOfFutures) {
                    for (int i = 0; i < future.get().size(); i++) {

                        counter2++;
                        for (int n = 0; n < future.get().get(i).size(); n++) {
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

                meanWaitingTime1 = Math.abs(meanWaitingTime1) / counter1;
                meanWaitingTime2 = Math.abs(meanWaitingTime2) / counter1;

                medianWaitingTime1 = Math.abs(medianWaitingTime1) / counter1;
                medianWaitingTime2 = Math.abs(medianWaitingTime2) / counter1;

                maxWaitingTime1 = Math.abs(maxWaitingTime1) / counter1;
                maxWaitingTime2 = Math.abs(maxWaitingTime2) / counter1;

                finalReport = new FinalReport(meanQueueLength1, meanQueueLength2, medianQueueLength1, medianQueueLength2,
                        maxQueueLength1, maxQueueLength2, meanWaitingTime1, meanWaitingTime2, medianWaitingTime1,
                        medianWaitingTime2, maxWaitingTime1, maxWaitingTime2);


                System.out.println("\n" + "Mean Queue Length Food Distribution: " + meanQueueLength1);
                System.out.println("Mean Queue Length Checkout: " + meanQueueLength2);
                System.out.println("Median Queue Length Food Distribution: " + medianQueueLength1);
                System.out.println("Median Queue Length Checkout: " + medianQueueLength2);
                System.out.println("Max Queue Length Food Distribution: " + maxQueueLength1);
                System.out.println("Max Queue Length Checkout: " + maxQueueLength2);
                System.out.println("Mean Waiting Time Food Distribution: " + meanWaitingTime1);
                System.out.println("Mean Waiting Time Checkout: " + meanWaitingTime2);
                System.out.println("Median Waiting Time Food Distribution: " + medianWaitingTime1);
                System.out.println("Median Waiting Time Checkout: " + medianWaitingTime2);
                System.out.println("Max Waiting Time Food Distribution: " + maxWaitingTime1);
                System.out.println("Max Waiting Time Checkout: " + maxWaitingTime2);

                break;
            default:
        }
    }
}