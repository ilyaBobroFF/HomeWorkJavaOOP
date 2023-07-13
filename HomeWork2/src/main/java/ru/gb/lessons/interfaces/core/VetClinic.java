package ru.gb.lessons.interfaces.core;

import java.util.ArrayList;
import java.util.List;


import ru.gb.lessons.interfaces.core.clients.Animal;
import ru.gb.lessons.interfaces.core.clients.Animals;
import ru.gb.lessons.interfaces.core.clients.Human;
import ru.gb.lessons.interfaces.core.clients.home.impl.Cat;
import ru.gb.lessons.interfaces.core.clients.home.impl.Dog;
import ru.gb.lessons.interfaces.core.clients.home.impl.Parrot;

public class VetClinic {
    private static List<Animals> animals = new ArrayList<>(); 
    public static void main(String[] args) {
        Human human = new Human("Пайтон");
        Cat cat1 = new Cat(0, "Cat1", 0, null, null);
        Parrot newkesha = new Parrot(0, "newkesha", 0, null, null);
        Dog dog1 = new Dog(1, "Sharik", 0, null, null);
        animals.add(cat1);
        animals.add(newkesha);
        animals.add(dog1);
        for (Animals element: animals) {
            heal(element);
        }
        //Вызов методов для проверки списка животных (пациентов) какие у них есть возможные действия
        getcanmotion(animals, "Runnable", " Бегать умеет");
        getcanmotion(animals, "Flyable", " Умеет летать");
        getcanmotion(animals, "Soundable", " Издавать звуки может");
        getcanmotion(animals, "Swimable", " Плавает!)");
 
 
    }
    private static void heal(Animals patients) {
        System.out.println(patients.getClassName() + "вылечен");
    }
    /**
     * Проверка на возможные действия
     * @param listcheck Список пациентов
     * @param motion Наимонование интерфейса действия
     * @param result Вывод сообщения по результату
     */
    public static void getcanmotion(List <Animals> listcheck, String motion, String result){
        for (Animals item : listcheck) {
            boolean ok = false;
            Class[] element = item.getClass().getInterfaces();
            for (Class interf : element) {
                if (interf.toString().contains(motion)) ok = true;   
            }
            if(ok) System.out.println(item.getClassName() + " " + ((Animal)item).getName() + result);   
        }
    }  
}

