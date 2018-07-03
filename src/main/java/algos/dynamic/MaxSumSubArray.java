package algos.dynamic;

import java.io.IOException;

/**
 * Created by sofia on 15/03/17.
 */
public class MaxSumSubArray {

    public static int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];

        sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            // sum of previous element and me!
            int prev_and_curr = sum[i - 1] + A[i];

            // who is bigger? Is it me or do I need help from previous sum?
            // I 'll call this my sum
            sum[i] = Math.max(A[i], prev_and_curr);

            // Did I even manage to beat current max? ;(
            max = Math.max(max, sum[i]);
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        int[] B;
        //B = new int[]{10, 4, 8, 3, 10};
        B = new int[]{10, -3, 4, -2, 1};

        int result = maxSubArray(B);

        System.out.print(result);
    }
}
