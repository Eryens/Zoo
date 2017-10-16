package zoo.animals;

import zoo.enums.Sexs;

import java.util.ArrayList;
import java.util.Random;

public class Wolf extends Animal implements Mammal {

    public Wolf() {
        specieName = "Wolf";
        pregancyDuration = 60;
        numberMinChild = 4;
        numberMaxChild = 7;
        weight = 35 ;
        height = 160 ;

        generateAnimal();
    }

    @Override
    public void getPregnant() {
        if (sex == Sexs.Female && !isPregnant) {
            this.isPregnant = true;
            this.pregnantSince = 0 ;
        }
    }

    @Override
    public ArrayList<Mammal> giveBirth() {

        ArrayList<Mammal> childs;
        childs = new ArrayList<>();

        Random randomGenerator = new Random() ;
        int numberOfChilds ;
        numberOfChilds = randomGenerator.nextInt(numberMaxChild + 1 - numberMinChild);
        numberOfChilds += numberMinChild ;

        //System.out.println(numberOfChilds + " enfants générés pour loup");

        for (int i = 0 ; i < numberOfChilds ; ++i) {
            childs.add(new Wolf());
        }

        return childs;

    }

    @Override
    public void scream() {
        System.out.println("AOUUUUUUU!!!!");
    }
}
