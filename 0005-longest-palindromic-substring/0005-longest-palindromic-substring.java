class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int start = 0, end = 0;
        for (double i = 0.5; i < length; i = i + 0.5 ) {
            int left = (int) (i - 0.5);
            int right = (int) (Math.ceil(i + 0.5));
            while (left >= 0 && right < length) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if (leftChar != rightChar) {
                    break;
                }
                if ((end - start) < (right - left)) {
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end + 1);
    }
}