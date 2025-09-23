class Solution {
    public int removeDuplicates(int[] nums) {
        int findCursor = 0;
        int inputCursor = 0;
        int result = 0;
        while (findCursor < nums.length) {
            if (findCursor > 0 && nums[findCursor] == nums[findCursor - 1]) {
                findCursor++;
                continue;
            }
            nums[inputCursor++] = nums[findCursor++];
            result++;
        }
        for (int i = result; i < nums.length; i++) {
            nums[i] = Integer.MIN_VALUE;
        }
        return result;
    }
}