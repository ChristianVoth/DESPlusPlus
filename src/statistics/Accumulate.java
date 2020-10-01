package statistics;

import Core.Model;

import java.util.ArrayList;
import java.util.List;




public class Accumulate extends Statistic{



    private List<ListEntry> accumulate = new ArrayList<>();
    public Accumulate(Model parentModel, String name) {
        super(parentModel, name);
    }

    public void update(double val){
        ListEntry entry = new ListEntry(val, getModel().currentTime());
        accumulate.add(entry);
        super.update(val);
    }

    public double getMean(){
            double timeWeightedSum = 0;
            double sumWeights = 0;
            for(int i = 0; i < accumulate.size() - 1; i++){
               timeWeightedSum += accumulate.get(i).value * (accumulate.get(i+1).timeOfChange - accumulate.get(i).timeOfChange);

            }
            for (int i = 0; i < accumulate.size() - 1; i++){
                sumWeights += accumulate.get(i + 1).timeOfChange - accumulate.get(i).timeOfChange;
            }

            return timeWeightedSum / sumWeights;
        }

    public double getStdDev(){

        double intermediateResult = 0;

        for (int i = 0; i < accumulate.size(); i++){
        intermediateResult += (Math.pow(accumulate.get(i).value - getMean(), 2));
        }
        return Math.sqrt(intermediateResult / accumulate.size());
    }

    @Override
    public String getReport() {
        return "Number of Observations: " + getObservations() + " Min: " + getMin() + ", Max: " + getMax()
                + ", Weighted Mean: " + getMean() + ", Weighted Standard Deviation: " + getStdDev()
                + " since last Reset at: " + getLastReset();
    }
}
