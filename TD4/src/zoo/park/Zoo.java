package zoo.park;

import zoo.animals.*;
import zoo.enums.Health;
import zoo.enums.Sexs;
import zoo.enums.Tidyness;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Zoo {

    private static Zoo instance ; // singleton
    private String name ;
    private int maxNumberOfCage ;
    private Employee employee ;
    private ArrayList<Cage> cages ;


    private Zoo() {

        name = "Le Zoo";
        employee = new Employee();
        maxNumberOfCage = 10;
        cages = new ArrayList<Cage>() ;

        // Ajout des animaux présent dans le zoo de base dans 3 cages
        Cage cageWolves = new Cage() ;
        Aquarium cageSharks = new Aquarium();
        Aviary cageEagles = new Aviary();

        Wolf wolf = new Wolf() ;
        Shark shark = new Shark() ;
        Eagle eagle = new Eagle() ;

        for (int i = 0 ; i < 5 ; ++i) {
            try {
                cageWolves.addAnimal(wolf);
                cageEagles.addAnimal(eagle);
                cageSharks.addAnimal(shark);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        cages.add(cageEagles);
        cages.add(cageSharks);
        cages.add(cageWolves);

        // ajout de 3 cages vides

        for (int i = 0 ; i < 3 ; ++i) {
            cages.add(new Cage());
        }

    }

    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo() ;
        }
        return instance ;
    }

    public void addCage (Cage cage) {
        this.cages.add(cage);
    }

    public void removeCage(Cage cage) {
        this.cages.remove(cage);
    }

    public int getAnimalNumberInZoo() {
        int animalNumberInZoo = 0;
        for (Iterator<Cage> cage = cages.iterator(); cage.hasNext(); ) {
            Cage currentCage = cage.next();
            animalNumberInZoo += currentCage.numbersOfAnimalsInCage;
        }
        return animalNumberInZoo;
    }

    public void displayAllAnimalsInZoo() {
        int cageNumber = 0;
        for (Iterator<Cage> cage = cages.iterator(); cage.hasNext(); ) {
            System.out.println("Cage " + cageNumber);
            Cage currentCage = cage.next();
            System.out.println(currentCage.name);
            currentCage.display();
            cageNumber += 1 ;
        }
    }

    // Changes randomly the health for all animals in the zoo
    public void randomlyChangeHealthofAnimals() {
        for (Iterator<Cage> cage = cages.iterator(); cage.hasNext(); ) { // Iterates through cages
            Cage currentCage = cage.next();

            for (Iterator<Animal> animal = currentCage.animals.iterator(); animal.hasNext(); ) { // Iterates through animals in cages

                Animal currentAnimal = animal.next();
                Random randomGenerator = new Random() ; // Generates a random number
                int randomSex ;
                randomSex = randomGenerator.nextInt(1);
                if (randomSex == 0) {
                    currentAnimal.setHealth(Health.Healthy);
                }
                else {
                    currentAnimal.setHealth(Health.Sick);
                }
            }
        }
    } // randomChangeHealthofAnimals

    public void randomlyChangeTidynessOfCages() {

        for (Iterator<Cage> cage = cages.iterator(); cage.hasNext(); ) { // Iterates through cages
            Cage currentCage = cage.next();

            Random randomGenerator = new Random() ; // Generates a random number
            int randomSex ;
            randomSex = randomGenerator.nextInt(2);
            switch (randomSex) {
                case 0:
                    currentCage.tidyness = Tidyness.Clean;
                    break;
                case 1:
                    currentCage.tidyness = Tidyness.Alright;
                    break;
                case 2:
                    currentCage.tidyness = Tidyness.Dirty;
                    break;
            }
        }
    }

    public void displayCages() {
        int iter = 1;
        for (Iterator<Cage> cage = cages.iterator(); cage.hasNext(); ) {
            Cage currentCage = cage.next();
            System.out.println("Cage " + iter + " : " + currentCage.display());
            iter += 1;
        }
    }

    public String getName() {
        return name;
    }

    public Employee getEmployee() {
        return employee;
    }
}
