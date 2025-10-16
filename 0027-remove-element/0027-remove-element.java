class Solution {
    public int removeElement(int[] nums, int val) {
        int removed = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                removed++;
            }
        }
        return nums.length - removed;
    }
}