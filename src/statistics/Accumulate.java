package statistics;

import Core.Model;

import java.util.ArrayList;
import java.util.List;

class ListEntry {
    double value;
    double timeOfChange;

    ListEntry(double v1, double v2){
        value = v1;
        timeOfChange = v2;
    }

}


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


    @Override
    public String getReport() {
        return null;
    }
}
