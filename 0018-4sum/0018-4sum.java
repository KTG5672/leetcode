class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int a = 0;
        while (a < nums.length - 3) {
            int d = a + 3;
            while (d <= nums.length - 1) {
                int b = a + 1;
                int c = d - 1;
                int subTarget = target - (nums[a] + nums[d]);
                while (b < c) {
                    if (subTarget == nums[b] + nums[c]
                            && !isSumOverflow(nums[a], nums[b], nums[c], nums[d])
                            && !res.contains(Arrays.asList(nums[a], nums[b], nums[c], nums[d]))) {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        int bValue = nums[b];
                        while (b < c && bValue == nums[b]) b++;
                    } else if (subTarget > nums[b] + nums[c]) {
                        b++;
                    } else {
                        c--;
                    }
                }
                d++;
            }
            a++;
        }
        return res;
    }

    boolean isSumOverflow(int a, int b, int c, int d) {
        boolean b1 = ((long) a + (long) b + (long) c + (long) d) > Integer.MAX_VALUE;
        boolean b2 = ((long) a + (long) b + (long) c + (long) d) < Integer.MIN_VALUE;
        return b1 || b2;
    }
}