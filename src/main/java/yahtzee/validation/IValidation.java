package yahtzee.validation;

public interface IValidation {
    boolean validateRoll(String roll);
    boolean validateCategory(int[] state, int category);
    boolean validateGameEnd(int[] state);
}
