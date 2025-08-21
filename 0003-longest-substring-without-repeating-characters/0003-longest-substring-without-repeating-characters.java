class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int currLength = 0;
        Set<Character> used = new HashSet<>();
        int pos = 0;
        while (pos < s.length()) {
            char ch = s.charAt(pos);
            if (used.contains(ch)) {
                result = Math.max(result, currLength);
                currLength = 0;
                used.clear();
                while (pos > 0 && ch != s.charAt(pos - 1)) pos--;
                continue;
            }
            used.add(ch);
            currLength++;
            pos++;
        }
        result = Math.max(result, currLength);

        return result;
    }
}