package zoo.park;

import zoo.animals.Marine;
import zoo.enums.Salinity;
import zoo.enums.Tidyness;

import java.util.ArrayList;

public class Aquarium extends Cage<Marine> {

    int depth;
    Salinity salinity;

    public Aquarium() {
        super();
        this.depth= 6000;
        this.salinity= Salinity.Salty;
    }

    public Aquarium(String name, int area, int capacity, int numbersOfAnimalsInCage, Tidyness tidyness, ArrayList animals, int depth, Salinity salinity) {
        super(name, area, capacity, numbersOfAnimalsInCage, tidyness, animals);
        this.depth = depth;
        this.salinity = salinity;
    }

    public void clean() {
        if (tidyness == Tidyness.Dirty && numbersOfAnimalsInCage == 0) {
            tidyness = Tidyness.Clean;
            System.out.println("L'employé vide le bassin pour le nettoyer et s'assure que l'eau est salée comme les larmes des joueurs de LoL");
        }
    }
}
