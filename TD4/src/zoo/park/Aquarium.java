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
        type = "Aquarium";
    }

    public Aquarium(String name, int area, int capacity, int numbersOfAnimalsInCage, Tidyness tidyness, ArrayList animals, int depth, Salinity salinity) {
        super(name, area, capacity, numbersOfAnimalsInCage, tidyness, animals);
        this.depth = depth;
        this.salinity = salinity;
        type = "Aquarium";
    }

    public void addAnimal(Marine animal) throws Exception {
        if (animals.isEmpty() && animal instanceof Marine) {
            animals.add(animal);
            numbersOfAnimalsInCage += 1 ;

        } // Les animaux sont de la bonne espèce
        else if (!animals.isEmpty() && animals.get(0).getSpecieName() == animal.getSpecieName()){
            animals.add(animal);
            numbersOfAnimalsInCage +=1 ;
        }
        else {
            throw new Exception("L'animal " + animal.getSpecieName() + " n'a pas pu être ajouté.");
        }
    }

    public void clean() {
        if ((tidyness == Tidyness.Dirty || tidyness == Tidyness.Alright) && numbersOfAnimalsInCage == 0) {
            tidyness = Tidyness.Clean;
            System.out.println("L'employé vide le bassin pour le nettoyer et s'assure que l'eau est salée comme les larmes des joueurs de LoL");
        }
        else {
            System.out.println("L'aquarium n'a pas pû être lavé");
        }
    }
}
