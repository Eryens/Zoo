package zoo.simulation;

import javafx.stage.Screen;
import zoo.park.Zoo;

import java.util.Scanner;

public class Simulation {

    private final static int NUMBER_OF_DAYS_IN_TURN = 5;
    private final static int NUMBER_OF_DAYS_UNTIL_SIMULATION_ENDS = 90;

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

    private static void turn() {
        Zoo.getInstance().displayCages();

        Scanner scanner = new Scanner(System.in) ;
        scanner.nextLine();


    }

    public static void mainGame() {

        Time time = new Time() ;
        ScreenFunctions.clearScreen();
        Zoo.getInstance();

        while (time.getDays() < NUMBER_OF_DAYS_UNTIL_SIMULATION_ENDS) {
            turn();
            time.timePasses(5);
        }


    }
}
