package homework;

public class User{
    private final String name;
    private Persister persister;
    public User(String name){
        this.persister = new Persister(this);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void save(){
        persister.save();
    }

    public void report(){
        persister.report();
    }
}
