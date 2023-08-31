import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {

    /*
        1. Two Sum

        https://leetcode.com/problems/two-sum/

        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.

        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
     */

    public static int[] twoSum(int[] nums, int target) {

        if (nums.length < 2 || nums.length > 10 * 10 * 10 * 10 + 1) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {-1, -1};
    }

    public int[] twoSum_HashMap(int[] nums, int target) {

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];

            if (hm.containsKey(difference)) {
                return new int[]{hm.get(difference), i};
            } else {
                hm.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        int[] nums1 = {3,2,4};
        int target1 = 6;
        System.out.println(Arrays.toString(twoSum(nums1, target1)));

        int[] nums2 = {3,3};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));

        int[] nums3 = {3,3};
        int target3 = 1;
        System.out.println(Arrays.toString(twoSum(nums3, target3)));

        int[] nums4 = {};
        int target4 = 1;
        System.out.println(Arrays.toString(twoSum(nums4, target4)));

        int[] nums5 = {0,0};
        int target5 = 0;
        System.out.println(Arrays.toString(twoSum(nums5, target5)));

        int[] nums6 = {2,-5,-7,9};
        int target6 = -12;
        System.out.println(Arrays.toString(twoSum(nums6, target6)));
    }
}
