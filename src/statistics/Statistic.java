package statistics;

import Core.Model;

abstract class Statistic  {
    private Reportable r;


    public Statistic(Model parentModel, String name) {

    }

    public abstract void update(double val);

    public abstract double getMax();

    public abstract double getMin();


}
