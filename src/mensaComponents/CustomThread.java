package mensaComponents;

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
                Mensa mensa = new Mensa("Mensa Model" + this.name);

                System.out.println(name + " gestartet");
                Mensa.simulate(mensa);
                System.out.println(name + " beendet");

                return mensa.generateReport();

        }
}
