package zoo.animals;

import zoo.enums.Sexs;

import java.util.ArrayList;
import java.util.Random;

public class Whale extends Animal implements Mammal, Marine {

    public Whale() {
        specieName = "Whale";
        pregancyDuration = 330;
        numberMinChild = 1;
        numberMaxChild = 1 ;
        height = 30000;
        weight = 170000 ;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("ui, ui, ui. PLOOF");
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

        //System.out.println(numberOfChilds + "enfants générés pour baleine");

        for (int i = 0 ; i < numberOfChilds ; ++i) {
            childs.add(new Whale());
        }

        return childs;
    }

    @Override
    public void swim() {
        System.out.println(specieName + " swims.");
    }
}
