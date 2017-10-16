package zoo;

import zoo.animals.*;
import zoo.park.*;
import zoo.simulation.Time;

import java.util.ArrayList;

public class Tests {

    //Test mammal
    public static void testMammals() {
        Wolf wolf = new Wolf() ;
        Tiger tiger = new Tiger() ;
        Bear bear = new Bear();
        Whale whale = new Whale() ;

        System.out.println("Est enceinte: " + wolf.isPregnant());
        wolf.getPregnant();
        System.out.println("Est enceinte: " + wolf.isPregnant());
        wolf.display();
        wolf.scream();

        System.out.println("Est enceinte " + tiger.isPregnant());
        tiger.getPregnant();
        System.out.println("Est enceinte " + tiger.isPregnant());
        tiger.display();
        tiger.scream();

        ArrayList<Mammal> wolfChilds;
        ArrayList<Mammal> tigerChilds;
        ArrayList<Mammal> whaleChilds;
        ArrayList<Mammal> bearChilds;



        for (int i = 0 ; i < 5 ; ++i) {
            wolfChilds = wolf.giveBirth();
            //tigerChilds= tiger.giveBirth();
            //whaleChilds= whale.giveBirth();
            //bearChilds = bear.giveBirth();


            System.out.println("Le loup a eu " + wolfChilds.size() + " enfants");
            //System.out.println("Le tigre a eu " + tigerChilds.size() + " enfants");
        }

    }

    public static void testGoldfish() {
        System.out.println("Test goldfish START");
        Goldfish goldfish = new Goldfish();
        goldfish.display();
        goldfish.layEggs();
        System.out.println("Test goldfish END");
    }

    public static void testCage() {

        /*
        cage.display();
        cage.clean();


        aquarium.display();
        aquarium.clean();

        Aviary aviary = new Aviary() ;
        aviary.display();
        aviary.clean();*/

        /*
        Whale whale = new Whale() ;
        Shark shark = new Shark() ;
        aquarium.addAnimal(whale);
        aquarium.addAnimal(whale);

        aquarium.display();

        aquarium.removeAnimal(whale);
        /*
        System.out.println("test baleine remove");

        aquarium.display();
        */

        Aquarium aquariumWhale = new Aquarium() ;
        Aquarium aquariumWhaleTwo = new Aquarium() ;
        Aquarium aquariumShark = new Aquarium() ;

        Whale whale = new Whale() ;
        Shark shark = new Shark() ;

        Employee antoine = new Employee();

        try {
            aquariumWhale.addAnimal(whale);
            aquariumWhaleTwo.addAnimal(whale);
            aquariumShark.addAnimal(shark);
            antoine.switchAnimalFromCage(aquariumWhale, aquariumWhaleTwo, whale);
            antoine.switchAnimalFromCage(aquariumWhaleTwo, aquariumShark, whale);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("WHALE ---------------------------------");
        aquariumWhale.display();
        System.out.println("WHALE TWO ---------------------------------");
        aquariumWhaleTwo.display();
        System.out.println("SHARK ---------------------------------");
        aquariumShark.display();

    }

    public static void testZoo() {
        Zoo.getInstance();
        System.out.println(Zoo.getInstance().getAnimalNumberInZoo() + " animaux dans le zoo");
        //Zoo.getInstance().displayAllAnimalsInZoo();
        Zoo.getInstance().randomlyChangeHealthofAnimals();
        Zoo.getInstance().randomlyChangeTidynessOfCages();
    }

    public static void testTime() {
        Time time = new Time() ;
        System.out.println(time.getDate());
        time.timePasses(50);
        System.out.println(time.getDate());
        time.timePasses(3000);
        System.out.println(time.getDays());
        System.out.println(time.getDate());
    }

    public static void main(String[] args) {

        //testMammals();
        //testGoldfish();

        //testCage();

        //testZoo();

        testTime();
    }

}
