package ru.gb.lessons.interfaces.core.drugStore;

public class Component {
    private String name;
    private String weight;
    private int power;

    public Component(String name, String weight, int power) {
        this.name = name;
        this.weight = weight;
        this.power = power;
    }
    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", power=" + power +
                '}';
    }
// Добавлены Геттеры для получение полей извне
    public String getName() { return this.name; }
    public String getWeight() { return this.weight; }
    public int getPower() {
        return this.power;
    }

}
