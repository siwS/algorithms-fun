package algos.arrays;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> intersection = new HashMap<>();

        for (int aNums1 : nums1) {
            intersection.put(aNums1, false);
        }

        for (int aNums2 : nums2) {
            if (intersection.containsKey(aNums2)) {
                intersection.put(aNums2, true);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : intersection.entrySet()) {
            if(entry.getValue()){
                resultList.add(entry.getKey());
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,2,1,5};
        int[] array2 = new int[]{2,2};
        int[] result = new ArrayIntersection().intersection(array1, array2);
        for (int aResult : result) {
            System.out.print(aResult + " ");
        }
    }
}
