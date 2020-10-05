package statistics;


import java.util.Comparator;

class ListEntry implements Comparable<ListEntry> {
    double value;
    double timeOfChange;

    ListEntry(double v1, double v2){

        value = v1;
        timeOfChange = v2;
    }



    @Override
    public int compareTo(ListEntry listOne) {

       return Double.compare(this.value, listOne.value);
    }
}