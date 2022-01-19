package yahtzee.rules;

import java.util.Arrays;

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
        return Arrays.stream(roll).parallel().reduce(0, Integer::sum);
    }

    private int yahtzeeScore(int[] roll) {
        for (int i : roll) {
            if (i != roll[0]) {
                return 0;
            }
        }
        return 50;
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
        int[] temp = Arrays.copyOf(roll, roll.length);
        Arrays.sort(temp);
        for(int i = temp.length-1; i>0; i--){
            if(temp[i] == temp[i-1]){
                return 2*temp[i];
            }
        }

        return 0;
    }

    private int single(int ruleindex, int[] roll) {
        int result = 0;
        for(int i: roll){
            if(i == ruleindex+1){
                result += i;
            }
        }
        return result;
    }
}
