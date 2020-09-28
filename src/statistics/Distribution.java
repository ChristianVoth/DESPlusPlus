package statistics;

import java.util.Random;


abstract class Distribution extends Reportable {
    private Reportable reportable;
    private long seed;

    public Distribution(long seed) {
        this.seed = seed;
    }

    public double sample(){
        return 0;
    }

    public long getSeed(){
        return this.seed;
    }

    public void reset(){
        super.reset();
        this.seed = 0L;

    }

    abstract void nextRandomDouble();
}
