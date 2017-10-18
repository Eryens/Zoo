package zoo.simulation;

import javafx.stage.Screen;
import zoo.animals.Animal;
import zoo.enums.FoodQuantity;
import zoo.enums.Tidyness;
import zoo.park.Cage;
import zoo.park.Zoo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {

    private final static int NUMBER_OF_DAYS_IN_TURN = 5;
    private final static int NUMBER_OF_DAYS_UNTIL_SIMULATION_ENDS = 90;

    private final static int VALUE_CLEAN_CAGE = 1000 ;
    private final static int VALUE_HUNGRY_ANIMAL = 50;
    private final static int VALUE_NOT_HUNGRY_ANIMAL = 100;


    private static int playerMoney =0;

    public static void introduction() {
        ScreenFunctions.clearScreen();
        System.out.println("Bienvenue dans " + Zoo.getInstance().getName());
        ScreenFunctions.sleep(2000);

        System.out.println("Vous incarnez " + Zoo.getInstance().getEmployee().name + " le fervent gardien du zoo.");
        ScreenFunctions.sleep(2000);

        System.out.println("Vous avez 3 mois pour obtenir le maximum d'argent");
        ScreenFunctions.sleep(2000);

        ScreenFunctions.emptyLine();
        System.out.println("Pour obtenir de l'argent, maintenez les cages propres et nourissez les animaux");
        ScreenFunctions.sleep(3000);
        System.out.println("Plus votre zoo est maintenu en bon ordre, plus vous obtiendrez d'argent.");

        ScreenFunctions.printDots(10);

        ScreenFunctions.emptyLine();
        System.out.println("On commence ?");
        System.out.println("Entrez n'importe quelle lettre dans le terminal puis appuyez sur entrée pour continuer: ");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    private static void displayMan() {
        ScreenFunctions.clearScreen();
        System.out.println("Manuel Simulation Zoo LP SILDA2I");
        ScreenFunctions.emptyLine();
        System.out.println("Examiner un enclos - son nombre - (exemple: \"1\" )");
        System.out.println("Tente de nettoyer une cage - clean nombre - (exemple: \"clean 1\")");
        System.out.println("Déplace un annimal d'une cage a une autre - move nombreDe NombreA (exemple: \"move 1 4\")");
        ScreenFunctions.emptyLine();
        System.out.println("Entrez n'importe quelle touche puis ENTREE pour quiter le man");


    }

    private static boolean turn() { // returns true if the turn is spent
        Zoo.getInstance().displayCages();

        Scanner scanner = new Scanner(System.in) ;

        System.out.println("Entrez \"rtfm\" pour le manuel ");
        String command = scanner.nextLine();
        int commandInt = 0 ;
        System.out.println("commande : " + command); // TO DELETE CHECK COMMAND

        try {
            commandInt = Integer.parseInt(command);
        } catch (Exception e) {}

        if (command.equals("rtfm")) { // RTFM COMMAND
            displayMan();
            scanner.nextLine();
            ScreenFunctions.clearScreen();
            return false; // returns false: le tour n'est pas passé
        }

        ScreenFunctions.clearScreen();

        // COMMAND CHECK CAGE
        if (commandInt >= 1 && commandInt <= Zoo.getInstance().getMaxNumberOfCages()) {
            Zoo.getInstance().getEmployee().checkCage(numberToCage(commandInt));
        }
        if (command.length() >= 6) { // If pour retirer les bugs de substring

            // COMMAND CLEAN CAGE
            if (command.substring(0,5).equals("clean")) {

                try {
                    commandInt = Integer.parseInt(command.substring(6,7));
                } catch (Exception e) {}
                if (commandInt >= 1 && commandInt <= Zoo.getInstance().getMaxNumberOfCages()) {
                    Zoo.getInstance().getEmployee().cleanCage(numberToCage(commandInt));
                }
                else {
                    System.out.println("Le nombre de la cage entrée est incorrect");
                }
            }

            // COMMAND MOVE
            if (command.substring(0,4).equals("move") && command.length() >= 8) {
                int commandInt2 = 0 ;
                try {
                    commandInt = Integer.parseInt(command.substring(5,6));
                    commandInt2 = Integer.parseInt(command.substring(7, 8));
                } catch (Exception e) {}

                if (commandInt >= 1 && commandInt <= Zoo.getInstance().getMaxNumberOfCages() &&
                    commandInt2 >= 1 && commandInt2 <= Zoo.getInstance().getMaxNumberOfCages()) {

                    try {
                        Zoo.getInstance().getEmployee().switchAnimalFromCage(numberToCage(commandInt), numberToCage(commandInt2), (Animal)numberToCage(commandInt).getAnimaltype());
                    }
                    catch (Exception e) {
                        System.out.println("Impossible de déplacer l'animal");
                    }
                }
                else {
                    System.out.println("Le nombre d'une cage entrée est incorrect");
                }
            }

            // COMMAND FEED
            if (command.substring(0,4).equals("feed") && command.length() >= 6) {
                try {
                    commandInt = Integer.parseInt(command.substring(5,6));
                } catch (Exception e) {}
                Zoo.getInstance().getEmployee().feedCage(numberToCage(commandInt), FoodQuantity.Normal);
            }
        }

        return true;
    }

    private static Cage numberToCage(int number) {

        int trueNumber = number - 1 ;
        return Zoo.getInstance().getCages().get(trueNumber);

    }

    private static void Payday() {
        System.out.println("C'EST L'HEURE DE LA PAIE $_$");
        System.out.println("L'inspecteur visite votre Zoo");
        ScreenFunctions.printDots(10);

        int numberOfCleanCage = 0;
        int numberOfNotHungryAnimals = 0;
        int numberOfHungryAnimals = 0;

        for (Iterator<Cage> cage = Zoo.getInstance().getCages().iterator(); cage.hasNext(); ) {
            Cage currentCage = cage.next();
            if (currentCage.getTidyness() == Tidyness.Clean) {
                numberOfCleanCage += 1;
            }
        }

        ArrayList<Animal> allAnimals ;
        allAnimals = Zoo.getInstance().getAllAnimalsInZoo();

        for (Iterator<Animal> animal = allAnimals.iterator(); animal.hasNext() ; ) {
            Animal currentAnimal = animal.next() ;
            if (currentAnimal.isHungry()) {
                numberOfHungryAnimals += 1;
            }
            else {
                numberOfNotHungryAnimals += 1;
            }
        }

        System.out.println(numberOfCleanCage + " cages propres: " + numberOfCleanCage * VALUE_CLEAN_CAGE + "$");
        System.out.println(numberOfNotHungryAnimals + " animaux n'ont pas faim: " + numberOfNotHungryAnimals * VALUE_NOT_HUNGRY_ANIMAL + "$");
        System.out.println(numberOfHungryAnimals + "animaux ont faim: -" + numberOfHungryAnimals + VALUE_HUNGRY_ANIMAL + "$");
        calculatePay(numberOfCleanCage, numberOfHungryAnimals, numberOfNotHungryAnimals);
        System.out.println("Salaire actuel: " + playerMoney + "$");

        Scanner scanner = new Scanner(System.in) ;
        scanner.nextLine();
        ScreenFunctions.clearScreen();


    }

    private static void calculatePay(int numberOfCleanCage, int numberOfHungryAnimals, int numberOfNotHungryAnimals) {

        playerMoney += ( VALUE_CLEAN_CAGE* numberOfCleanCage) ;
        playerMoney += ( VALUE_NOT_HUNGRY_ANIMAL * numberOfNotHungryAnimals);
        playerMoney -= ( VALUE_HUNGRY_ANIMAL * numberOfHungryAnimals);
    }

    public static void mainGame() {

        Time time = new Time() ;
        ScreenFunctions.clearScreen();
        Zoo.getInstance();

        Zoo.getInstance().randomlyChangeHungerofAnimals();

        while (time.getDays() < NUMBER_OF_DAYS_UNTIL_SIMULATION_ENDS) {

            if (time.getDays() != 0 && time.getDays() % 15 == 0) {
                Payday() ;
                Zoo.getInstance().randomlyChangeTidynessOfCages();
                Zoo.getInstance().randomlyChangeHungerofAnimals();
            }

            if (turn()) {
                time.timePasses(NUMBER_OF_DAYS_IN_TURN);
                int daysLeft = NUMBER_OF_DAYS_UNTIL_SIMULATION_ENDS - time.getDays();
                System.out.println("5 jours on passés, " + daysLeft + " jours restant");
            }


        }


    }
}
