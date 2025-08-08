class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int input = x;
        int reversed = 0;
        while (input != 0) {
            reversed = reversed * 10 + (input % 10);
            input = input / 10;
        }
        return x == reversed;
    }
}