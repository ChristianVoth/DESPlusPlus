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

        private int numOfSimulations = 4;

        List<Report> listOfReports = new ArrayList<>();

        /**
         * Constructor of CustomThread.
         * @param name
         *              java.lang.String : The name of the thread
         */
        CustomThread(String name) {
            this.name = name;
        }

        /**
         * The run() method of a thread.
         *
         * Everything that is written in here is executed in the new created thread
         */


        @Override
        public Object call() throws Exception {



                System.out.println(name + " gestartet");
                for(int i = 0; i < numOfSimulations; i++) {

                        Mensa mensa = new Mensa("Mensa Model" + this.name + i);
                        Mensa.simulate(mensa);
                        listOfReports.add(mensa.generateReport());



                }
                System.out.println(name + " beendet");


                return listOfReports;


        }


}
