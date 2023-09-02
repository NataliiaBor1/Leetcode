import java.util.*;

public class L15_3Sum {
    /*
        15. 3Sum

        https://leetcode.com/problems/3sum/

        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
        and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.

        Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

        Example 2:
        Input: nums = [0,1,1]
        Output: []
        Explanation: The only possible triplet does not sum up to 0.

        Example 3:
        Input: nums = [0,0,0]
        Output: [[0,0,0]]
        Explanation: The only possible triplet sums up to 0.

        Constraints:
        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105
    */

    public List<List<Integer>> threeSumTripleLoop(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && i != j && j != k && i != k) {
                        List<Integer> midResult = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(midResult);
                        if (!result.contains(midResult)) {
                            result.add(midResult);
                        }
                        break;
                    }
                }
            }
        }

        return result;
    }


    public List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        if (nums == null || nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new L15_3Sum().threeSum2(nums));

    }
}
