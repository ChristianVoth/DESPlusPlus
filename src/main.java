public class main extends Event {

    public main(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
    }

    public static void main (String[] args) {

        EventListImpl bla = new EventListImpl();



        Entity entity = null;
        Model model = null;
        bla.insert(new Event(model, "Arrival", 10.8, entity) {
            @Override
            void eventRoutine() {

            }
        });
        bla.showList();
        bla.insert(new Event(model, "Stark", 10.6, entity) {
            @Override
            void eventRoutine() {

            }
        });
        bla.showList();
        bla.insert(new Event(model, "nicht", 10.3, entity) {
            @Override
            void eventRoutine() {

            }
        });
    bla.showList();

    }

    @Override
    void eventRoutine() {

    }
}
