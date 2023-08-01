package homework;

public class Persister {
    private final User user;

    public Persister(User user){
        this.user = user;
    }


    public void report(){
        System.out.println("Report for user: " + user.getName());
    }
}
