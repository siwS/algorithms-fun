package algos.simple_exercises;

/**
 * Function that calculates power(x,n)
 *
 * by @sofia
 */
public class Power {
    public double myPow(double x, int n) {
        long m=n;
        if (n < 0) {
            x = 1 / x;
            m =((long)(-1))*n;
        }

        if (m == 0)
            return 1;

        double y = 1.0;
        while (m>1) {
            if (m%2==0) {
                x = x*x;
                m = m/2;
            } else {
                y = x*y;
                x = x*x;
                m = (m-1)/2;
            }
        }
        return x*y;
    }

    public static void main(String[] args) {
        int n = 10;
        double x = 2.00000;
        double result = new Power().myPow(x,n);
        System.out.println(result);
    }
}
