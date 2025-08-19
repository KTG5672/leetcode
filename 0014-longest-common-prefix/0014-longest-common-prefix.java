class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLenPos = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minLenPos = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        String minStr = strs[minLenPos];
        for (int i = 0; i < minLen; i++) {
            char ch = minStr.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}