package statistics;

import core.Model;

public abstract class Statistic extends Reportable {

    private double min = 0;
    private double max = 0;

    public Statistic(Model parentModel, String name) {
        super(parentModel, name);
    }

    public void update(double val) {
        if (val > max)
            max = val;
        if (val < min)
            min = val;
        incObservations();
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
