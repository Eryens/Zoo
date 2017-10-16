package zoo.animals;

import java.util.ArrayList;
import java.util.Random;

public class Eagle extends Animal implements FlyingAnimal, Oviparous {

    public Eagle() {
        specieName = "Eagle";
        pregancyDuration = 0;
        numberMinChild = 2;
        numberMaxChild = 2 ;
        height = 80;
        weight = 5 ;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("AMERICAAAAAAAAAA");
    }

    @Override
    public void fly() {
        System.out.println("flap flap flap");
    }

    @Override
    public ArrayList<Oviparous> layEggs() {
        ArrayList<Oviparous> childs;
        childs = new ArrayList<>();

        Random randomGenerator = new Random() ;
        int numberOfChilds ;
        numberOfChilds = randomGenerator.nextInt(numberMaxChild + 1 - numberMinChild);
        numberOfChilds += numberMinChild ;

        //System.out.println(numberOfChilds + "enfants générés pour eagle");

        for (int i = 0 ; i < + numberOfChilds ; ++i) {
            childs.add(new Eagle());
        }

        return childs;
    }
}
