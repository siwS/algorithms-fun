package algos.search;

/**
 * Simple binary search
 *
 * by @sofia
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int lowerIndex = 0;
        int upperIndex = nums.length-1;

        while(searchMore(lowerIndex, upperIndex) ) {
            int median = (lowerIndex + upperIndex)/2;
            if (target==nums[median]) {
                return median;
            }

            if (target>nums[median]) {
                lowerIndex = median;
            } else {
                upperIndex = median;
            }
        }

        if (nums[lowerIndex]==target)
            return lowerIndex;

        if (nums[upperIndex]==target)
            return upperIndex;

        return -1;
    }

    private static boolean searchMore(int lowerIndex, int upperIndex) {
        return !(lowerIndex == upperIndex || lowerIndex + 1 == upperIndex);
    }

    public static void main(String[] args) {
        int[] B = new int[]{0,10,12,42,75,86,90};

        int result = search(B, 42);
        System.out.println(result);
    }
}

