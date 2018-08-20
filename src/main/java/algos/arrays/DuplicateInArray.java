package algos.arrays;

import algos.search.BinarySearch;

import java.util.Arrays;

public class DuplicateInArray {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        // Quicksort
        Arrays.sort(nums);

        // Complexity n * logn due to binary search
        int countExists = 0;
        for (int i=1; i < nums.length; i++) {
            int existsIndex = BinarySearch.search(nums, i);
            if (existsIndex != -1) {
                sum -= i;
                countExists++;
            }
        }

        return sum/(nums.length - countExists);
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,3,4,2,2,2};
        int result = new DuplicateInArray().findDuplicate(array1);
        System.out.print(result);
    }
}
