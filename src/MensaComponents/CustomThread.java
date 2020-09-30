package MensaComponents;



public class CustomThread extends java.lang.Thread {


        String name;

        CustomThread(String name) {
            this.name = name;
        }
        public void run() {
                System.out.println(name + " gestartet" );
                        Mensa.simulate();
                        System.out.println(name + " beendet");

        }
}
