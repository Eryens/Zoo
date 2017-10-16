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
    }

    public Aviary(String name, int area, int capacity, int numbersOfAnimalsInCage, Tidyness tidyness, ArrayList<FlyingAnimal> animals, int height) {
        super(name, area, capacity, numbersOfAnimalsInCage, tidyness, animals);
        this.height = height;
    }
    /*
    public void addAnimal(A animal) {
        if (!animals.isEmpty()) {
            animals.add(animal);
            numbersOfAnimalsInCage += 1 ;

        } // Les animaux sont de la bonne espèce
        else {
            animals.add(animal);
            numbersOfAnimalsInCage =1 ;
        }
    }
    */
    public void clean() {
        if (tidyness == Tidyness.Dirty && numbersOfAnimalsInCage == 0) {
            tidyness = Tidyness.Clean;
            System.out.println("L'employé nettoye le toit, c'est super dangereux");
        }
    }

}
