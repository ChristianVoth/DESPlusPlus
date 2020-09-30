package statistics;

import Core.Model;
import MensaComponents.Mensa;

abstract class Statistic  {
    private Reportable r;
    private Mensa model;


    public Statistic(Model parentModel, String name) {
        this.model = (Mensa)parentModel;
    }

    public abstract void update(double val);

    public abstract double getMax();

    public abstract double getMin();


}
