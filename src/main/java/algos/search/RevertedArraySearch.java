package algos.search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * by @sofia
 */
public class RevertedArraySearch {
    private static int search(int[] nums, int target) {
        int lowerIndex = 0;
        int upperIndex = nums.length-1;

        if (upperIndex < 0)
            return -1;

        while(searchMore(lowerIndex, upperIndex) ) {
            int median = (lowerIndex + upperIndex)/2;
            if (target==nums[median]) {
                return median;
            }

            if (nums[median] > nums[lowerIndex]) {
                if (nums[lowerIndex] <= target && target < nums[median]) {
                    upperIndex = median;
                } else {
                    lowerIndex = median;
                }
            } else {
                if (nums[median] < target && target <= nums[upperIndex]) {
                    lowerIndex = median;
                } else {
                    upperIndex = median;
                }
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
        int[] B;
        int search;

        B= new int[]{4,5,6,7,8,1,2,3};
        search = 8;

        //B = new int[]{1,3,5};
        //search = 1;

        //B = new int[]{4,5,6,7,0,1,2};
        //search =  1;

        int result = search(B, search);
        System.out.println(result);
    }
}

