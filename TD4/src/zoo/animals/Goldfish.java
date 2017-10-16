package zoo.animals;

import java.util.ArrayList;
import java.util.Random;

public class Goldfish extends Animal implements Marine, Oviparous {

    public Goldfish() {

        specieName = "Goldfish";
        pregancyDuration = 0;
        numberMinChild = 2000;
        numberMaxChild = 6000 ;
        height = 6;
        weight = 0.05 ;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("... bloup");
    }

    @Override
    public void swim() {
        System.out.println(specieName + " swims.");
    }

    @Override
    public ArrayList<Oviparous> layEggs() {
        ArrayList<Oviparous> childs;
        childs = new ArrayList<>();

        Random randomGenerator = new Random() ;
        int numberOfChilds ;
        numberOfChilds = randomGenerator.nextInt(numberMaxChild + 1 - numberMinChild);
        numberOfChilds += numberMinChild ;

        //System.out.println(numberOfChilds + "enfants générés pour goldfish");

        for (int i = 0 ; i < + numberOfChilds ; ++i) {
            childs.add(new Goldfish());
        }

        return childs;
    }
}
