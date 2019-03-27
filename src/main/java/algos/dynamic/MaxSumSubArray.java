package algos.dynamic;

import java.io.IOException;

/**
 * The problem of given an array A, determining the max sum of a subarray of A.
 * Or in other words the consecutive elements that give the biggest sum.
 */
public class MaxSumSubArray {

    public static int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum_so_far = new int[A.length];

        sum_so_far[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            // sum of previous sum so far and current element
            int sum_with_current = sum_so_far[i - 1] + A[i];

            // is adding new element to the previous sum greater than just taking the current element?
            sum_so_far[i] = Math.max(A[i], sum_with_current);

            // is the new sum greater than the current max?
            max = Math.max(max, sum_so_far[i]);
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        int[] B;
        //B = new int[]{10, 4, 8, 3, 10};
        B = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};

        int result = maxSubArray(B);

        System.out.print(result);
    }
}
