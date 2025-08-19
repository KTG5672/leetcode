class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length +  nums2.length;
        boolean isOdd = len % 2 == 1;
        int center = len / 2;
        int curr = 0;
        int num1Curr = 0;
        int num2Curr = 0;
        int[] results = new int[2];
        while (curr <= center) {
            if (num2Curr >= nums2.length) {
                setResults(results, curr, center, nums1, num1Curr);
                num1Curr++;
            } else if (num1Curr >= nums1.length) {
                setResults(results, curr, center, nums2, num2Curr);
                num2Curr++;
            } else if (nums1[num1Curr] < nums2[num2Curr]) {
                setResults(results, curr, center, nums1, num1Curr);
                num1Curr++;
            } else if (nums1[num1Curr] >= nums2[num2Curr]) {
                setResults(results, curr, center, nums2, num2Curr);
                num2Curr++;
            }
            curr++;
        }
        return isOdd ? results[1] : ((double) results[0] + (double) results[1]) / 2;
    }

    void setResults(int[] results, int curr, int center, int[] nums, int numCurr) {
        if (curr == center - 1) {
            results[0] = nums[numCurr];
        } else if (curr == center) {
            results[1] = nums[numCurr];
        }
    }
}