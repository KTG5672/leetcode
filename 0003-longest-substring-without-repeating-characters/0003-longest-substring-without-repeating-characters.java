class Solution {
    public int lengthOfLongestSubstring(String s) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        Set<Character> used = new HashSet<>();
        int pos = 0;
        while (pos < s.length()) {
            char ch = s.charAt(pos);
            if (used.contains(ch)) {
                result = compareAndGetPreResult(result, sb);
                sb = new StringBuilder();
                used.clear();
                while (pos > 0 && ch != s.charAt(pos - 1)) pos--;
                continue;
            }
            used.add(ch);
            sb.append(ch);
            pos++;
        }
        result = compareAndGetPreResult(result, sb);

        return result.length();
    }

    String compareAndGetPreResult(String result, StringBuilder sb) {
        if (result.length() <= sb.length()) {
            result = sb.toString();
        }
        return result;
    }
}