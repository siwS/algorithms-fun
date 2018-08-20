package algos.simple_exercises;

/**
 * Function that calculates Square Root of a number
 */
public class Sqrt {
    public static int mySqrt(int x) {
        if (x==1 || x==2 || x==3)
            return 1;

        for (int i=0; i<=(x/2); i++) {
            long sq = (long)i*(long)i;
            if (sq == x)
                return i;
            if (sq > x)
                return i-1;
        }
        return x/2;
    }

    public static void main(String[] args) {
        int result = mySqrt(2147483647);
        System.out.println(result);
    }
}

