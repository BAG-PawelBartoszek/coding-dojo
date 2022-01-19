package yahtzee;

import yahtzee.validation.RollValidation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
    public void run() {
        System.out.println("Willkommen bei Yahtzee!");
        System.out.println("Bitte gib das Würfelergebnis ein! (Bsp.: '1 2 3 4 5')");
        String roll = getRoll();
        if (RollValidation.validateRoll(roll)) {
            System.out.println("In welche ");
            int[] numbersIntArray = Stream.of(roll.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

    public String getRoll() {
        Scanner rollGetter = new Scanner(System.in);
        String roll = rollGetter.nextLine();
        return roll;
    }
}
