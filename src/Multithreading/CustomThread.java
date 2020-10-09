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

import mensaComponents.Mensa;
import statistics.QueueReport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * The CustomThread class is used to create threads.
 */
public class CustomThread implements Callable {

        /**
         * name stores the name of the Thread.
         */
        String name;

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
        List<ArrayList<QueueReport>> listOfReports = new ArrayList<>();

        /**
         *
         * @param nname
         * @param nnumOfSimulations
         * @param nnumOfFD
         * @param nnumOfCO
         */
        CustomThread(String nname, int nnumOfSimulations,
                     int nnumOfFD, int nnumOfCO) {
            this.name = nname;
            this.numOfSimulations = nnumOfSimulations;
            this.numOfFD = nnumOfFD;
            this.numOfCO = nnumOfCO;
        }

        /**
         * The run() method of a thread.
         *
         * Everything that is written in here
         * is executed in the new created thread
         */
        @Override
        public Object call() throws Exception {


                System.out.println(numOfFD + " " + numOfCO);
                System.out.println(name + " gestartet");
                for (int i = 0; i < numOfSimulations; i++) {

                        Mensa mensa = new Mensa("Mensa Model"
                                + this.name + i, numOfFD, numOfCO);
                        listOfReports.add(mensa.simulate(mensa));



                }
                System.out.println(name + " beendet");
                System.out.println(listOfReports);


                return listOfReports;


        }


}
