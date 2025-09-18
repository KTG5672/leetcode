class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            left = i + 1;
            right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;
                if (sum < target) {
                    left++;
                } else  {
                    right--;
                }
            }
        }
        return result;
    }
}