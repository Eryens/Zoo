package zoo.animals;

import java.util.ArrayList;
import java.util.Random;

public class Shark extends Animal implements Marine, Oviparous {

    public Shark() {
        specieName = "Shark";
        pregancyDuration = 0;
        numberMinChild = 5;
        numberMaxChild = 8 ;
        height = 500;
        weight = 1700 ;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("musique des dents de la mer");
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

        //System.out.println(numberOfChilds + "enfants générés pour shark");

        for (int i = 0 ; i < + numberOfChilds ; ++i) {
            childs.add(new Shark());
        }

        return childs;
    }
}