class Solution {
    private static final Map<Character, Integer> romanMap = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1);

    public int romanToInt(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (i < length -1 && romanMap.get(ch) < romanMap.get(s.charAt(i + 1))) {
                result += romanMap.get(s.charAt(i + 1)) - romanMap.get(ch);
                i++;
                continue;
            }
            result += romanMap.get(ch);
        }

        return result;
    }
}