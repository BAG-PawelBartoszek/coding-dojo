package yahtzee.rules;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        int[] expected = {2,3,4,5,6};
        for (int i : expected) {
            if (IntStream.of(roll).noneMatch(x -> x == i)) {
                return 0;
            }
        }
        return 20;
    }

    private int smallStraight(int[] roll) {
        int[] expected = {1,2,3,4,5};
        for (int i : expected) {
            if (IntStream.of(roll).noneMatch(x -> x == i)) {
                return 0;
            }
        }
        return 15;
    }

    private int fourOfAKind(int[] roll) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(roll));
        if (set.size <= 4) {
            int[] sorted = Arrays.sort(roll);
            int num = 0;
            int count = 0;
            for (int i = 0; i < sorted.length; i++) {
                if (count == 4) {
                    return 4 * num;
                }
                if (sorted[i] == num) {
                    count++;
                } else {
                    num = sorted[i];
                    count++;
                }
            }
        } else {
            return 0;
        }
    }

    private int threeOfAKind(int[] roll) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(roll));
        if (set.size <= 3) {
            int[] sorted = Arrays.sort(roll);
            int num = 0;
            int count = 0;
            for (int i = 0; i < sorted.length; i++) {
                if (count == 3) {
                    return 3 * num;
                }
                if (sorted[i] == num) {
                    count++;
                } else {
                    num = sorted[i];
                    count++;
                }
            }
        } else {
            return 0;
        }
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
