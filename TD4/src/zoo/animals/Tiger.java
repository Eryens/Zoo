package zoo.animals;

import zoo.enums.Sexs;

import java.util.ArrayList;
import java.util.Random;

public class Tiger extends Animal implements Mammal {

    public Tiger() {
        specieName = "Tiger";
        pregancyDuration = 100;
        numberMinChild = 2;
        numberMaxChild = 3 ;
        height = 300;
        weight = 250;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("Rawrrrrrr xD");
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

        //System.out.println(numberOfChilds + "enfants générés pour tigre");

        for (int i = 0 ; i < numberOfChilds ; ++i) {
            childs.add(new Tiger());
        }

        return childs;
    }
}
