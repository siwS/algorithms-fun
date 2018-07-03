package algos.dynamic;
import java.io.*;


/**
 * Created by sofia on 30/06/18.
 */

public class SherlockArrays {

    /**
     * get_max_cost(B):
     N = B.length
     hi,low=0,0
     for i as 1..N-1: # note we skip index 0
     high_to_low_diff = abs(B[i-1] - 1)
     low_to_high_diff = abs(B[i] - 1)
     high_to_high_diff = abs(B[i] - B[i-1])

     low_next = max(low, hi+high_to_low_diff)
     hi_next = max(hi+high_to_high_diff, low+low_to_high_diff)

     low = low_next
     hi = hi_next

     return max (hi,low)
     * @param b
     * @return
     */
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

        int[] B= new int[5];
        //B = new int[]{10, 4, 8, 3, 10};
        B = new int[]{10, 3, 4, 2, 1};

        int result = cost2(B);
    }
}

