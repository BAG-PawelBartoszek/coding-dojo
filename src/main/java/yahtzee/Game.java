package yahtzee;

import yahtzee.rules.Rule;
import yahtzee.rules.RuleImpl;
import yahtzee.validation.IValidation;
import yahtzee.validation.Validation;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
    public void run() {
        System.out.println("Willkommen bei Yahtzee!");
        int[] state = new int[15];
        Arrays.fill(state, -1);
        System.out.println("Bitte gib das Würfelergebnis ein! (Bsp.: '1 2 3 4 5')");
        String rollInput = getRoll();
        IValidation validation = new Validation();
        if (validation.validateRoll(rollInput)) {
            // Kategorieausgabe
            System.out.println("In welche Kategorie soll das Ergebnis");

            int[] roll = Stream.of(rollInput.split(" ")).mapToInt(Integer::parseInt).toArray();

            int category = getCategory();
            // validateCategoryInput
            if (validation.validateCategory(state, category)) {
                Rule rule = new RuleImpl();
                int points = rule.calculatePointsForRollAndCategory(category, roll);
                state[category] = points;
            }
        }
        if (validation.validateGameEnd(state)){
            System.out.println("Herzlichen Glückwunsch du hast diese Punktzahl erreicht: " + Arrays.stream(state).reduce());
        }

        // GameEnd

    }

    public String getRoll() {
        Scanner rollGetter = new Scanner(System.in);
        String roll = rollGetter.nextLine();
        return roll;
    }

    public int getCategory() {
        Scanner rollGetter = new Scanner(System.in);
        int roll = rollGetter.nextInt();
        return roll;
    }
}
