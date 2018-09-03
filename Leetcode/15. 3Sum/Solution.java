class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int left;
        int right;
        /** 1. O(nlogn) sorting, so we can proceed in a certain ordering */
        Arrays.sort(nums);
        /** 2. Fixed first number, so the problem becomes b + c = -a */
        for (int i = 0; i < nums.length; i++) {
            /** Skip the duplicated number of first one */
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            /** 3. Finding b and c, converted to 2 sum problem */
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int result = nums[i] + nums[left] + nums[right];
                /** Skip the duplicated number of second one */
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                /** 4. Find one answer */
                if (result == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                } else if (result < 0) {
                    /** Sum too small, increase the second number */
                    left++;
                } else {
                    /** Sum too large, decrease the third number */
                    right--;
                }
            }
        }
        return ans;
    }
}