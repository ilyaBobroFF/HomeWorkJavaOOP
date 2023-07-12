package ru.gb.lessons.interfaces.core.personal;

// У класса доктора и класса медсестры много общего можно создать через абстрактный класс
public class Nurse {
    String name;
    int age;
    String profession;

    /**
     * Класс для медсестры
     * @param name - Имя
     * @param age - Возраст
     * @param profession - Направление деятельности
     */
    public Nurse(String name, int age, String profession){
        this.name = name;
        this.age = age;
        this.profession = profession;
    }
    /*
    * Выполнение помощи при работе доктора
    */
    public void assist (Doctor doc){
        System.out.println(name +" Совместно выполняет работу с доктором "+ doc.getname());
    }
    /*
     * Выполнение уборки кабинета после осмотра
     */
    public void clean(String office){
        System.out.println(this.name +" Выполнила уборку кабинета "+ office);

    }
}
