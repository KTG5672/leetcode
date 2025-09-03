class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] results = new String[numRows];
        Arrays.fill(results, "");
        int index = 0;
        int length = s.length();
        while (index < length) {
            boolean isDown = (index / (numRows - 1)) % 2 == 0;
            int row = isDown ? (index % (numRows - 1)) : (numRows - 1) - (index % (numRows - 1));
            results[row] += "" + s.charAt(index);
            index++;
        }
        return String.join("", results);
    }
}