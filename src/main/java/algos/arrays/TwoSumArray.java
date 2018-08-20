package algos.arrays;

import java.util.HashMap;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Assumptions:
 * Answers (both index1 and index2) are not zero-based.
 * Each input would have exactly one solution and you may not use the same element twice.
 */
public class TwoSumArray {

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> sums = new HashMap<>();

        for (int i=0; i < numbers.length; i++) {
            int pair = target - numbers[i];
            if (sums.get(pair) != null) {
                return new int[]{sums.get(pair), i};
            } else {
                sums.put(numbers[i], i);
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,7,11,15};
        int[] result = new TwoSumArray().twoSum(array1, 13);
        for (int aResult : result) {
            System.out.print(aResult + " ");
        }
    }
}
