package zoo.park;

import zoo.animals.Animal;
import zoo.animals.FlyingAnimal;
import zoo.animals.Mammal;
import zoo.enums.Tidyness;

import java.util.ArrayList;

public class Aviary extends Cage<FlyingAnimal> {

    private int height ;

    public Aviary() {
        super();
        this.height = 1000;
        type = "Aviary";
    }

    public Aviary(String name, int area, int capacity, int numbersOfAnimalsInCage, Tidyness tidyness, ArrayList<FlyingAnimal> animals, int height) {
        super(name, area, capacity, numbersOfAnimalsInCage, tidyness, animals);
        this.height = height;
        type = "Aviary";
    }

    public void addAnimal(FlyingAnimal animal) throws Exception {
        if (animals.isEmpty() && animal instanceof FlyingAnimal) {
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
            System.out.println("L'employé nettoye le toit, c'est super dangereux");
        }
        else {
            System.out.println("La volière n'a pas pû être lavée");
        }
    }

}
