class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> appear = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (appear.containsKey(target - nums[i]))
                return new int[] {appear.get(target - nums[i]), i};
            else
                appear.put(nums[i], i);
        }
        return new int[] {};
    }
}