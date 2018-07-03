package algos.dynamic;

import java.io.IOException;

public class ConstructArrays {

    static long countArrays(int n, int k, int x) {
        int MOD = 10000000 + 7;

        long[] dpNext = new long[2];
        long[] dp = new long[2];

        dp[0] = 1;
        dp[1] = 0;
        for (int i = 0; i < n - 1; ++i) {
            dpNext[0] = (dp[1] * (k - 1)) % MOD;
            dpNext[1] = (dp[0] + dp[1] * (k - 2)) % MOD;
            dp[0] = dpNext[0];
            dp[1] = dpNext[1];
        }
        return dp[1];
    }

    static long recursive_count(int n, int k) {
        long count = 0;

        if (n==1 && k==1) {
            return 1L;
        }
        if (n==1) {
            return 0L;
        }

        count = (long)Math.pow(k-1, n-2) - recursive_count(n-1, k);
        return count;
    }

    public static void main(String[] args) throws IOException {

        int n=15;
        int k=20;
        int x=3;
        long answer1 = countArrays(n, k, x);

        long answer2 = recursive_count(n-1, k);
        System.out.println();


    }
}
