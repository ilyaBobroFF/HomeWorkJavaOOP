// Дз: добавить в класс Animal методы двигаться(toGo), летать(fly), плавать(swim). Создать по два класса
// наследника Animal, умеющих летать, плавать, бегать. При этом добиться того, чтобы не умеющие летать или плавать, не могли этого сделать.
//  САМОЕ ВАЖНОЕ! В файле readme.md в репозитории гитхаб описать
// какие проблемы в таком проектировании Вы увидели, а также там же написать возникшие при выполнении дз вопросы
// (если они есть)


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Slon", 32, "true", "White",
        "Mammal", new Owner("Stas"), 4);
        Animal animal1 = new Animal("Black", "Bird", 2);
        System.out.println(animal.getAge());
        animal.setAge(3);
        System.out.println(animal.getAge());
        System.out.println(animal);
        Animal animal0 = new Animal(null, null, null, null, null, null, null);
        animal0.getAge();
        System.out.println(animal0);
        Animal cat = new Animal(null, null, null, null, null, null, null);
        List <Animal> animals = new ArrayList<>();
        animals.add(new Dog(null, null, null));
        animals.add(new Cat(null, null, null));
        animals.add(cat);
        animals.add(animal);
        animals.add(animal1);
        System.out.println(animals);
        Cat barsik = new Cat(null,"Большой кот",null);
            barsik.Hunt();
        // Для задания
        Fish gold = new Fish("Rybka", 1, null, "Gold", "Selyd", null, null);
        gold.fly(); // Полетит ли fish
        gold.swim();
        barsik.fly();
        barsik.toGo();


    }
}
