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
    private int numOfSimulations;

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
    private int studentGenerator;

    private int numOfStaff;

    private FinalReport finalReport;

    public Multithreading(int numOfThreads, int numOfSimulations, int numOfStaff, int studentGenerator) {
        this.numOfThreads = numOfThreads;
        this.numOfSimulations = numOfSimulations;
        this.numOfStaff = numOfStaff;
        this.studentGenerator = studentGenerator;
    }

    /**
     * @param nnumOfThreads
     * @param nnumOfSimulations
     * @param nnumOfFD
     * @param nnumOfCO
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

    public FinalReport getFinalReport() {
        return finalReport;
    }
    /**
     *
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

        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processors);
        List<Future<ArrayList<ArrayList<QueueReport>>>> listOfFutures
                = new ArrayList<>();

        System.out.println("Hauptthread gestartet");

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

                meanWaitingTime1 = Math.abs(meanWaitingTime1) / counter1;
                meanWaitingTime2 = Math.abs(meanWaitingTime2) / counter1;

                medianWaitingTime1 = Math.abs(medianWaitingTime1) / counter1;
                medianWaitingTime2 = Math.abs(medianWaitingTime2) / counter1;

                maxWaitingTime1 = Math.abs(maxWaitingTime1) / counter1;
                maxWaitingTime2 = Math.abs(maxWaitingTime2) / counter1;

                finalReport = new FinalReport(meanQueueLength1, meanQueueLength2, medianQueueLength1, medianQueueLength2,
                        maxQueueLength1, maxQueueLength2, meanWaitingTime1, meanWaitingTime2, medianWaitingTime1,
                        medianWaitingTime2, maxWaitingTime1, maxWaitingTime2);


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

                break;
            default:
        }
    }
}