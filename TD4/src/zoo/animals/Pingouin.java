package zoo.animals;

import java.util.ArrayList;
import java.util.Random;

public class Pingouin extends Animal implements FlyingAnimal, Oviparous, Marine {

    public Pingouin() {
        specieName = "Pingouin";
        pregancyDuration = 0;
        numberMinChild = 5;
        numberMaxChild = 10 ;
        height = 30;
        weight = 2 ;

        generateAnimal();
    }

    @Override
    public void scream() {
        System.out.println("404: club pingouin non trouvé");
    }

    @Override
    public void fly() {
        System.out.println("contrairement aux manchots, les pingouins volent");
    }

    @Override
    public void swim() {
        System.out.println("all pingouins on titanic survived");
    }

    @Override
    public ArrayList<Oviparous> layEggs() {
        ArrayList<Oviparous> childs;
        childs = new ArrayList<>();

        Random randomGenerator = new Random() ;
        int numberOfChilds ;
        numberOfChilds = randomGenerator.nextInt(numberMaxChild + 1 - numberMinChild);
        numberOfChilds += numberMinChild ;

        //System.out.println(numberOfChilds + "enfants générés pour pingouin");

        for (int i = 0 ; i < + numberOfChilds ; ++i) {
            childs.add(new Pingouin());
        }

        return childs;
    }
}
