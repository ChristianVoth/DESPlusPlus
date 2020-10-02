package mensaComponents;

/**
 * The CustomThread class is used to create threads.
 */
public class CustomThread extends java.lang.Thread {

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
        public void run() {
                System.out.println(name + " gestartet" );
                // Starting the simulate() method from the mensa model
                Mensa.simulate();
                System.out.println(name + " beendet");

        }



}
