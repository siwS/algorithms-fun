package algos.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order
 */
public class ArrayIntersectionWithDuplicates {

    class Appearances {
        int num1;
        int num2;

        Appearances(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Appearances> intersection = new HashMap<>();

        for (int aNums1 : nums1) {
            if (intersection.get(aNums1) != null) {
                intersection.get(aNums1).num1++;
            } else {
                intersection.put(aNums1, new Appearances(1, 0));
            }
        }

        for (int aNums2 : nums2) {
            if (intersection.get(aNums2) != null) {
                intersection.get(aNums2).num2++;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Appearances> entry : intersection.entrySet()) {
            if(entry.getValue().num2 != 0){
                int min = Math.min(entry.getValue().num1, entry.getValue().num2);
                for (int i=0; i<min; i++) {
                    resultList.add(entry.getKey());
                }
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,2,1,5};
        int[] array2 = new int[]{2,2};
        int[] result = new ArrayIntersectionWithDuplicates().intersection(array1, array2);
        for (int aResult : result) {
            System.out.print(aResult + " ");
        }
    }
}
