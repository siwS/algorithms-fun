package algos.search;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * by @sofia
 */
public class GuessGame  {

    private int guessNumber(int target) {
        int lowerIndex = 0;
        int upperIndex = target;

        while(searchMore(lowerIndex, upperIndex) ) {
            int median = upperIndex - (upperIndex - lowerIndex)/2;
            if (guess(median) ==0) {
                return median;
            }

            if (guess(median) ==1) {
                lowerIndex = median;
            } else {
                upperIndex = median;
            }
        }

        if (guess(lowerIndex)==0)
            return lowerIndex;

        if (guess(upperIndex)==0)
            return upperIndex;

        return -1;
    }

    private boolean searchMore(int lowerIndex, int upperIndex) {
        return !(lowerIndex == upperIndex || lowerIndex + 1 == upperIndex);
    }

    private int guess(int x) {
        return Integer.compare(1702766719, x);
    }

    public static void main(String[] args) {
        int result = new GuessGame().guessNumber(2126753390);
        System.out.println(result);
    }
}


