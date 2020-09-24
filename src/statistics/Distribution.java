package statistics;

abstract class Distribution {

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
