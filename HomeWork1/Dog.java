
public class Dog extends Animal{

    public Dog(String color, String species, Integer legsCount) {
        super(color, species, legsCount);
        
    }
    @Override
    public void fly(){
       System.out.println ("Я не летаю. Я - " + super.species);
    }
    
}
