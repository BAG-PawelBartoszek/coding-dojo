package yahtzee.validation;


import java.util.stream.IntStream;

public class Validation implements IValidation {

    @Override
    public boolean validateRoll(String roll) {

        return false;
    }

    @Override
    public boolean validateCategory(int[] state, int category) {
        return state[category] == -1;
    }

    @Override
    public boolean validateGameEnd(int[] state) {
        return IntStream.of(state).anyMatch(x -> x != -1);
    }
}
