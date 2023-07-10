
public class Animal {
    private String name;
    private Integer age;
    private String vaccination;
    private String color;
    protected String species; // Изменил на protected для возможности управления в наследниках
    private Owner owner;
    private Integer legsCount;

    public Animal(String name, Integer age, String vaccination, String color,
            String species, Owner owner, Integer legsCount) {
        this.name = name;
        this.age = age;
        this.vaccination = vaccination;
        this.color = color;
        this.species = species;
        this.owner = owner;
        this.legsCount = legsCount;
    }

    public Animal(String color, String species, Integer legsCount) {
        this(null, null, null, color, species, null, legsCount);
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void toGo(){
        System.out.println("Я умею бегать, так как я - " + this.species);
    }
    public void fly(){
        System.out.println("Я летаю, так как я - " + this.species);
    }
    public void swim(){
        System.out.println("Поплыву, так как я - " + this.species);
    }
    @Override
    public String toString() {
    
        return String.format("Animal: {name = %s, owner = %s}", name, owner);
    }
}