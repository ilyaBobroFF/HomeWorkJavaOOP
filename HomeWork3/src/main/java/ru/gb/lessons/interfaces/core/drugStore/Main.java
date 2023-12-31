package ru.gb.lessons.interfaces.core.drugStore;

import org.w3c.dom.ls.LSSerializer;
import ru.gb.lessons.interfaces.core.clients.DoctorSpecialities;
import ru.gb.lessons.interfaces.core.personal.Doctor;

import java.io.Serializable;
import java.util.*;

import static ru.gb.lessons.interfaces.core.clients.DoctorSpecialities.THERAPIST;

public class Main {
    public static void main(String[] args) {
        Pharmacy pharmacy1 = new Pharmacy();
        Component comp1 = new Component("Penicillin", "10 mg", 100);
        Component comp2 = new Component("Spirit", "100 g", 100);

        pharmacy1.addComponent(comp1).addComponent(comp2);

//        

        List<Marker> markers = new ArrayList<>();
        Doctor doc1 = new Doctor(234, "��������", THERAPIST, "8(495)429-43-23");
//        markers.add().add();

//        while (((Iterator<Component>) pharmacy1).hasNext()){
//            System.out.println(pharmacy1.next());
//        }
        System.out.println(pharmacy1);

//        DogPharmacy dogPharmacy = new DogPharmacy();
//        System.out.println(dogPharmacy.hashCode());
        for (Component elem : pharmacy1) {
            System.out.println(elem);
        }

        Pharmacy pharmacy2 = new Pharmacy();
        Component comp3 = new Component("Penicillin", "10 mg", 100);
        Component comp4 = new Component("Spi", "100 g", 100);
        pharmacy2.addComponent(comp3).addComponent(comp4);

        Pharmacy pharmacy3 = new Pharmacy();
        Component comp5 = new Component("Penicillin", "10 mg", 100);
        Component comp6 = new Component("Water", "100 g", 100);
        pharmacy3.addComponent(comp5).addComponent(comp6);

        List<Pharmacy> nomenclature = new ArrayList<>();
        nomenclature.add(pharmacy3);
        nomenclature.add(pharmacy1);
        nomenclature.add(pharmacy2);

        System.out.println(nomenclature);
        Collections.sort(nomenclature);
        System.out.println("============================================================================");
        System.out.println(nomenclature);
        
        // 
        pharmacy2.addComponent(comp5);
        HashSet<Pharmacy> rrr = new HashSet<>();
        System.out.println("Первый вывод" + rrr);
        Pharmacy pharmacy7 = new Pharmacy();
        pharmacy7.addComponent(comp1).addComponent(comp6);
        System.out.println(rrr.add(pharmacy1));
        System.out.println(rrr.add(pharmacy3));
        System.out.println(rrr.add(pharmacy2));
        System.out.println(rrr.add(pharmacy2));
        System.out.println(rrr.add(pharmacy7));
        System.out.println(rrr+"Выполнено");
        String fi = "PPPP";
        String gi = new String("PPPP");
        String li = "jhjhjhj";
        System.out.println( "fi" + fi.hashCode());
        System.out.println( "gi" + gi.hashCode());
        System.out.println( "li" + li.hashCode());
        System.out.println(fi==gi);


        



    }
}
