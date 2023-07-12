package ru.gb.lessons.interfaces.core.personal;

import ru.gb.lessons.interfaces.core.clients.Animal;
import ru.gb.lessons.interfaces.core.clients.Animals;

public class Doctor {
    String name;
    String profession;
    int age;
    int experience;
    int office;
/**
 * Конструктор для класса Доктор
 * @param name - Имя
 * @param profession - Должность
 * @param age - Возраст
 * @param experience - Длительность опыта
 * @param office - Номер рабочего кабинета
 */
    public Doctor(String name, String profession, int age, int experience, int office){
        this.name = name;
        this.profession = profession;
        this.age = age;
        this.experience = experience;
        this.office = office;
    }
    public String getname(){
        return this.name;
    }
    /*
     * Осмотр доктором
     */
    public void inspection (Animals patient){
        System.out.println(this.profession +" "+ this.name +" Выполнил осмотр пациента: " + ((Animal)patient).getName());
    }
    /*
     * Выдача рецепта для лечения
     */
    public void recipe (Animals patient){
        System.out.println(this.profession +" "+ this.name + " Выписал рецепт лечения хозяину по имени: " + 
            ((Animal)patient).getOwner().getName());
    }

}
