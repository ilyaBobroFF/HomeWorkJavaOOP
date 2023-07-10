
public class Fish extends Animal{

    public Fish(String name, Integer age, String vaccination, String color, String species, Owner owner,
            Integer legsCount) {
        super(name, age, vaccination, color, species, owner, legsCount);  
    }
    @Override
    public void toGo(){
        System.out.println("Я не бегаю. Я - " + super.species);
    }
    @Override
    public void fly(){
       System.out.println ("Я не летаю. Я - " + super.species);
    }

}
