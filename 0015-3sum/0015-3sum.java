class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            inputList.add(nums[i]);
        }
        inputList.sort(Integer::compareTo);
        int bound = -1;
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) >= 0) {
                bound = i;
                break;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i <= bound) {
            int left = i + 1;
            int right = inputList.size() - 1;
            int curr = inputList.get(i);
            while (left < right) {

                int leftValue = inputList.get(left);
                int rightValue = inputList.get(right);
                if (leftValue + rightValue + curr == 0) {
                    res.add(List.of(curr, leftValue, rightValue));
                    while ((left < right) && leftValue == inputList.get(left)) {
                        left++;
                    }
                } else if (leftValue + rightValue + curr > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            while ((i <= bound) && curr == inputList.get(i)) {
                i++;
            }
        }
        return res;
    }
}