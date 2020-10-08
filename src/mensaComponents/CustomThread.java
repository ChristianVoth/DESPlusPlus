package mensaComponents;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * The CustomThread class is used to create threads.
 */
public class CustomThread implements Callable {

        /**
         * name stores the name of the Thread.
         */
        String name;

        private int numOfSimulations;
        private int numOfFD;
        private int numOfCO;

        List<Report> listOfReports = new ArrayList<>();

        /**
         * Constructor of CustomThread.
         * @param name
         *              java.lang.String : The name of the thread
         */
        CustomThread(String name, int numOfSimulations, int numOfFD, int numOfCO) {
            this.name = name;
            this.numOfSimulations = numOfSimulations;
            this.numOfFD = numOfFD;
            this.numOfCO = numOfCO;
        }

        /**
         * The run() method of a thread.
         *
         * Everything that is written in here is executed in the new created thread
         */


        @Override
        public Object call() throws Exception {


                System.out.println(numOfFD + " " + numOfCO);
                System.out.println(name + " gestartet");
                for(int i = 0; i < numOfSimulations; i++) {

                        Mensa mensa = new Mensa("Mensa Model" + this.name + i, numOfFD, numOfCO);
                        Mensa.simulate(mensa);
                        listOfReports.add(mensa.generateReport());



                }
                System.out.println(name + " beendet");


                return listOfReports;


        }


}
