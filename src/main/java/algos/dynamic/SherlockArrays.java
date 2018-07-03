package algos.dynamic;
import java.io.*;


/**
 * Sherlock Arrays is the problem of determining an array A given an array B so that:
 *
 * - Array B containing elements B1, B2,..., Bn is provided as input.
 * - Elements A1, A2,.., An for array A can be any integer such that 1 <= Ai <= Bi
 * - The sum | A1 - A2 | + | A2 - A3 | + .... | An-1 - An | is max
 */
public class SherlockArrays {

    static int cost2(int[] b){
        int n = b.length;
        int sum_hi=0, sum_low =0;
        int high_to_low;
        int low_to_high;
        int high_to_high;

        for (int i=1; i<n; i++) {
            // If I become a 1, do I help?
            high_to_low = Math.abs(b[i-1] -1);

            // If my previous buddy becomes a 1, does this help?
            low_to_high = Math.abs(b[i]-1);

            // Ye know what, could be grand if we are both ourselves.
            high_to_high = Math.abs(b[i]-b[i-1]);

            // that will be the case if I am low.
            sum_low = Math.max(sum_low, sum_hi + high_to_low);

            // that will be the case if I stay high
            sum_hi = Math.max(sum_hi+ high_to_high, sum_low+low_to_high);
        }

        return Math.max(sum_low, sum_hi);
    }


    public static void main(String[] args) throws IOException {
        int[] B = new int[]{10, 3, 4, 2, 1};

        int result = cost2(B);
        System.out.println(result);
    }
}

