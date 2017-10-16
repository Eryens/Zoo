package zoo.animals;

import zoo.enums.Sexs;

import java.util.ArrayList;
import java.util.Random;

public class Bear extends Animal implements Mammal {

    public Bear() {
        specieName = "Bear";
        pregancyDuration = 210;
        numberMinChild = 1;
        numberMaxChild = 3 ;
        height = 198;
        weight = 272 ;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("GRRRRRRrrrr");
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

        //System.out.println(numberOfChilds + " enfants générés pour l'ours");

        for (int i = 0 ; i <numberOfChilds ; ++i) {
            childs.add(new Bear());
        }

        return childs;
    }
}
