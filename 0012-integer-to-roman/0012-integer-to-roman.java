class Solution {

    private static final char[] powerOfTen = new char[] {'M', 'C', 'X', 'I'};
    private static final char[] sub = new char[] {'D', 'L', 'V'};
    private static final int MAX_LENGTH = 4;

    public String intToRoman(int num) {
        String numStr = num + "";
        StringBuilder sb = new StringBuilder();
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            char ch = numStr.charAt(i);
            int powerOfTenIndex = (MAX_LENGTH - length) + i;
            int subIndex = powerOfTenIndex- 1;

            if (ch == '9') {
                sb.append("" + powerOfTen[powerOfTenIndex] + powerOfTen[powerOfTenIndex - 1]);
                ch = (char) (ch - 9);
            } else if (ch >= '5') {
                sb.append("" + sub[subIndex]);
                ch = (char) (ch - 5);
            } else if (ch == '4') {
                sb.append("" + powerOfTen[powerOfTenIndex] + sub[subIndex]);
                ch = (char) (ch - 4);
            }
            int tenIndex = ch - '0';
            sb.repeat(powerOfTen[powerOfTenIndex], tenIndex);
        }

        return sb.toString();
    }
}