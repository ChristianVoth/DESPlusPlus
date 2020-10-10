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
         * A variable to store the numbOfSimulations.
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
         * A variable to store the number of staff.
         */
        private int numOfStaff;

        /**
         * A variable to store the value of the student generator.
         */
        private int studentGenerator;

        /**
         * A List of Array Lists of Queue Reports.
         */
        List<ArrayList<QueueReport>> listOfReports = new ArrayList<>();

        /**
         * Custom Thread constructor.
         * @param name
 *              java.lang.String : The name of the Thread
         * @param numOfSimulations
 *              int : The number of simulations
         * @param numOfStaff
         *      int : The number of staffs
         * @param studentGenerator
 *              int : The int value of the student generator
         */
        public CustomThread(String name, int numOfSimulations, int numOfStaff, int studentGenerator) {
                this.name = name;
                this.numOfSimulations = numOfSimulations;
                this.numOfStaff = numOfStaff;
                this.studentGenerator = studentGenerator;
        }

        /**
         * Custom Thread constructor.
         * @param name
 *             java.lang.String : The name of the Thread
         * @param numOfSimulations
 *             int : The number of simulations
         * @param numOfFD
         *      int : The number of food distribution
         * @param numOfCO
         *      int : The number of checkouts
         * @param numOfStaff
         *      int : The number of staff
         * @param studentGenerator
 *              int : The int value of the student generator
         */
        CustomThread(String name, int numOfSimulations,
                     int numOfFD, int numOfCO, int numOfStaff, int studentGenerator) {
            this.name = name;
            this.numOfSimulations = numOfSimulations;
            this.numOfFD = numOfFD;
            this.numOfCO = numOfCO;
            this.numOfStaff = numOfStaff;
            this.studentGenerator = studentGenerator;
        }


        /**
         * The run() method of a thread.
         *
         * Everything that is written in here
         * is executed in the new created thread
         */
        @Override
        public Object call() throws Exception {

                System.out.println(name + " gestartet\n" );
                switch (studentGenerator) {
                        case 1:
                                for (int i = 0; i < numOfSimulations; i++) {

                                        Mensa mensa = new Mensa("Mensa Model"
                                                + this.name + i, numOfStaff, studentGenerator);
                                        listOfReports.add(mensa.simulate(mensa));
                                }
                                System.out.println(name + " beendet\n");
                        break;
                        case 2:
                                for (int i = 0; i < numOfSimulations; i++) {

                                        Mensa mensa = new Mensa("Mensa Model"
                                                + this.name + i, numOfFD, numOfCO, numOfStaff, studentGenerator);
                                        listOfReports.add(mensa.simulate(mensa));
                                }
                                System.out.println(name + " beendet\n");
                        break;
                        default:
                }
                return listOfReports;
        }
}
