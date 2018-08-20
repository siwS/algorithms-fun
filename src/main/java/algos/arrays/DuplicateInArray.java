package algos.arrays;

import algos.search.BinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Restrictions:
 * O(1) memory
 * less than O(n^2) complexity
 * same duplicate can exist multiple times
 */
public class DuplicateInArray {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        // Collections sort uses mergesort ( O(nlogn) )
        // While Arrays.sort uses quicksort ( O(n^2) )
        // Mergesort offers stable sorting complexity
        // While quicksort generally tends to be faster
        // https://www.cs.auckland.ac.nz/software/AlgAnim/qsort3.html
        // We choose stable complexity nlogn for purposes of this problem
        List<Integer> list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        nums = list.stream().mapToInt(i->i).toArray();

        // Complexity n * log n due to binary search
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
        System.out.println(result);
    }
}
