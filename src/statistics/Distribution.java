package statistics;

import java.util.Random;


abstract class Distribution {
    private Reportable reportable;

    public double sample(){
        return 0;
    }

    public long getSeed(){
        return 0;
    }

    public void reset(){

    }

    abstract void nextRandomDouble();
}
