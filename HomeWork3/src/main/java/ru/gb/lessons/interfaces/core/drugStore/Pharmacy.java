package ru.gb.lessons.interfaces.core.drugStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Marker {
    private List<Component> components;
    private int componentsCount;

    public Pharmacy() {
        this.components = new ArrayList<>();
        this.componentsCount = 0;
    }
    /**
     * Метод добавления в Pharmacy новых элементов.
     * С контроллем наличия уже существующих, по ИМЕНИ компонента
     */
    public Pharmacy addComponent (Component component) {
        if (!checkBeforeAdd(component)){
            this.components.add(component);
            this.componentsCount++;
            System.out.println("Компонент "+component.getName()+" Добавлен");
        }
        else {
            System.out.println("Компонент "+component.getName()+" Уже есть. Его не добавить!");
        }
    return  this;
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", index=" + componentsCount +
                '}'+"Total power = "+getPower(this)+"\n";
    }

    @Override
    public Iterator<Component> iterator() {
//        return new Iterator<Component>() { //Анонимный класс
//            public Component next() {
//                return components.get(componentsCount++);
//            }
//
//            public boolean hasNext() {
//                return componentsCount < components.size();
//            }
//        };
        return new ComponentIterator();
    }

    @Override
    public int compareTo(Pharmacy o) {
        int pow1 = getPower(this);
        int pow2 = getPower(o);
        if (pow1 != pow1) {
            return Integer.compare(pow1, pow2);
        }
        else return compareName(o);
//        Альтернативная запись:
//        if (pow1 > pow2) return 1;
//        else if (pow1 < pow2) return -1;
//        else return 0;
    }

    private int getPower (Pharmacy pharm) {
        int result = 0;
        for (Component elem: pharm.getComponents()) {
            result += elem.getPower();
        }
        return result;
    }
    /**
     * Метод проверки наличия компонента в Pharmacy (лекарстве)
     */
    private boolean checkBeforeAdd (Component O) {
        boolean find = false;
        for (Component item : this.components) {
            if(item.getName().equals(O.getName())){
                find = true;
                break;
            }
        }
        return find;
    }
    /**
     * Метод сложения названий всех компонентов в одну строку
     */
    private String sumName (Pharmacy o){
        String result = "";
        for (Component item : o.getComponents()) {
            result = result.concat(item.getName());
        }
        return  result;
    }
    /**
     * Метод сравнения суммарной длины имен всех компонентов
     */
    private int compareName(Pharmacy o) {
        int name1size = sumName(this).length();
        int name2size = sumName(o).length();
        return Integer.compare(name1size, name2size);
    }
}
