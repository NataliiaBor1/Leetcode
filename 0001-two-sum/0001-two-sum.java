class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> res = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int second = target - nums[i];

            if(res.containsKey(second)) {
                return new int[] {i, res.get(second)};
            }
            res.put(nums[i], i);
        }

        return new int[]{};
    }
}