class Solution {
    public int myAtoi(String s) {
        long longResult = 0;
        String input = s.trim();
        boolean negative = false;

        int pos = 0;
        while (pos < input.length()) {
            char ch = input.charAt(pos);
            if (pos == 0 && (ch == '+' || ch == '-')) {
                negative = ch == '-';
                pos++;
                continue;
            }
            if (ch < '0' || ch > '9') {
                break;
            }
            longResult = longResult * 10 + (ch - '0');
            if (Integer.MAX_VALUE < longResult) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            pos++;
        }
        longResult = negative ? longResult * -1 : longResult;
        return (int) longResult;
    }
}