package ru.gb.lessons.interfaces.core.clients.home.impl;

import java.time.LocalDate;

import ru.gb.lessons.interfaces.core.clients.motion.Runnable;
import ru.gb.lessons.interfaces.core.clients.home.Pet;
import ru.gb.lessons.interfaces.core.clients.motion.Flyable;
import ru.gb.lessons.interfaces.core.clients.motion.Soundable;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;
/**
 * Класс для попугаев, наследник от Pet
 */
public class Parrot extends Pet implements Flyable, Soundable, Runnable{
    public Parrot(){

    }
    public Parrot(int id, String name, int numberOfLimbs, LocalDate registrationDate, Owner owner) {
        super(id, name, numberOfLimbs, registrationDate, owner);
    }
    @Override
    public int run(int speed) {
        speed /= 2; //Попугай быстро не бегает
        System.out.println(CLASS_NAME + " " + this.name + " Прогуливается со скоростью = " + speed);
        return speed;
    }
    @Override
    public int sound(int volume) {
        volume *= 1; //Попугай в разговоре копирует человека
        System.out.println(CLASS_NAME + " " + this.name + " Просто разговаривает = " + volume);
        return volume;
    }
    @Override
    public int fly(int speed) {
        speed *= 2; //Попугай может быстро летать
        System.out.println(CLASS_NAME + " " + this.name + " Летит со скоростью = " + speed);
        return speed;
    }
    
}
