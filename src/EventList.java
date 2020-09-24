public interface EventList {



    public void insert(Event e);

    public Event getFirst();

    public Event removeFirst();

    public int remove(Event e);

    public int size();

    public boolean isEmpty();

    public void showList();
}
