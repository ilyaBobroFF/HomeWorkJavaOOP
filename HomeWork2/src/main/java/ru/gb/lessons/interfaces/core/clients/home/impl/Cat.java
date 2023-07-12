package ru.gb.lessons.interfaces.core.clients.home.impl;

import ru.gb.lessons.interfaces.core.clients.home.Pet;
import ru.gb.lessons.interfaces.core.clients.motion.Runnable;
import ru.gb.lessons.interfaces.core.clients.motion.Soundable;
import ru.gb.lessons.interfaces.core.clients.owners.Owner;

import java.time.LocalDate;

/**
 Одна из реализаций домашнего животного
 */
public class Cat extends Pet implements Runnable, Soundable {
    protected String breed; // Для кошек добавлено поле "порода"
    public Cat() {
        
    }

    public Cat(int id, String name, int numberOfLimbs, LocalDate registrationDate, Owner owner) {
        super(id, name, numberOfLimbs, registrationDate, owner);
        
    }


    @Override
    public int run(int speed){
        speed *= 2;   // Кошка бежит в два раза быстрее, чем от нее хотят
        System.out.println(CLASS_NAME + " " + this.name +" Быстро бежит со скоростью = " + speed);
    return speed;
    }
    @Override
    public int sound(int volume){
        volume /= 2; //Кошка уменьшает громкость звука
        System.out.println(CLASS_NAME + " " + this.name + " Мяукает с громкостью = " + volume);
        return volume;
    }   
}