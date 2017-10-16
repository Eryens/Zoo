package zoo.simulation;

import java.io.IOException;

public class ScreenFunctions {

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printDots(int number) {
        for (int i = 0 ; i < number ; ++i) {
            System.out.print(". ");
            sleep(500);
        }
    }

    public static void clearScreen() {
        for (int i = 0 ; i < 50 ; ++i) {
            System.out.println("");
        }
    }

    public static void emptyLine() {
        System.out.println("");
    }

}
