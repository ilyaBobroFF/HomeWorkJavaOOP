package ru.gb.lessons.interfaces.core.clients.home.impl;

import ru.gb.lessons.interfaces.core.clients.home.Pet;
import ru.gb.lessons.interfaces.core.clients.motion.Runnable;
import ru.gb.lessons.interfaces.core.clients.motion.Soundable;
import ru.gb.lessons.interfaces.core.clients.motion.Swimable;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;

import java.time.LocalDate;

/**
 Одна из реализаций домашнего животного
 */
public class Dog extends Pet implements Runnable, Soundable, Swimable {
    public Dog() {
    }

    public Dog(int id, String name, int numberOfLimbs, LocalDate registrationDate, Owner owner) {
        super(id, name, numberOfLimbs, registrationDate, owner);
    }
    
    @Override
    public int sound(int volume){
        volume *= 2; //Собака громко гавкает
        System.out.println(CLASS_NAME + " " + this.name + " Лает с громкостью = " + volume);
        return volume;
    }

    @Override
    public int run(int speed) {
     //Собака бежит как ей сказали
        System.out.println(CLASS_NAME + " " + this.name + " Просто бежит куда сказали = " + speed);
        return speed;
    }

    @Override
    public int swim(int speed) {
    speed /= 3; //Собака обычно не очень хорошо плавает
        System.out.println(CLASS_NAME + " " + this.name + " Подплывает к спасению = " + speed);
        return speed;
    }      
}
