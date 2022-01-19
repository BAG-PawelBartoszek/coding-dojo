package yahtzee.rules;

public class RuleImpl implements Rule {

    @Override
    public int calculatePointsForRollAndCategory(int ruleindex, int[] roll) {
        return switch (ruleindex) {
            case 1,2,3,4,5,6 -> single(ruleindex, roll);
            case 7 -> pair(roll);
            case 8 -> twoPairs(roll);
            case 9 -> threeOfAKind(roll);
            case 10 -> fourOfAKind(roll);
            case 11 -> smallStraight(roll);
            case 12 -> largeStraight(roll);
            case 13 -> fullHouse(roll);
            case 14 -> yahtzeeScore(roll);
            case 15 -> chance(roll);
            default -> throw new IllegalArgumentException("Wrong Index not in [1, 15]");
        };
    }

    private int chance(int[] roll) {
        return 0;
    }

    private int yahtzeeScore(int[] roll) {
        return 0;
    }

    private int fullHouse(int[] roll) {
        return 0;
    }

    private int largeStraight(int[] roll) {
        return 0;
    }

    private int smallStraight(int[] roll) {
        return 0;
    }

    private int fourOfAKind(int[] roll) {
        return 0;
    }

    private int threeOfAKind(int[] roll) {
        return 0;
    }

    private int twoPairs(int[] roll) {
        return 0;
    }

    private int pair(int[] roll) {
        return 0;
    }

    private int single(int ruleindex, int[] roll) {
        return 0;
    }
}
