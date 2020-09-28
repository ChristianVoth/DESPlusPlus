package Core;

public class BasicModelComponent implements ModelComponent {

    private Model parent;
    private String basicModelComponentName;

    public BasicModelComponent(Model parentModel, String name) {

        if (name == null)
            basicModelComponentName = "unnamed";
        else
            basicModelComponentName = name;

        parent = parentModel;
    }

    public BasicModelComponent(String name) {
        if (name == null)
            basicModelComponentName = "unnamed";
        else
            basicModelComponentName = name;

    }


    @Override
    public Model getModel() {

        return parent;
    }

    @Override
    public String getName(){

        return basicModelComponentName;
    }
}
