package yahtzee.rules;

public interface Rule {

    int calculatePointsForRollAndCategory(int ruleindex, int[] roll);
}
