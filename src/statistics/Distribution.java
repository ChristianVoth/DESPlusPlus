package statistics;

import Core.Model;

import java.util.Random;


abstract class Distribution extends Reportable {
    private long seed;
    private Random random = new Random(seed);

    public Distribution(Model parentModel, String name, long seed) {
        super(parentModel, name);

        this.seed = seed;
    }

    public abstract double sample();

    public long getSeed(){

        return this.seed;
    }

    public void reset(){
        super.reset();
        this.seed = 0L;

    }
    protected double nextRandomDouble(){

        return random.nextDouble();
    }
}
