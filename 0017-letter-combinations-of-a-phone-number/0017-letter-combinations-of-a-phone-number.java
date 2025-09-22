class Solution {
    private String[] letters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            int letterIndex = (ch - '0') - 2;
            String letter = letters[letterIndex];
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < letter.length(); j++) {
                char unit = letter.charAt(j);
                if (i == 0) {
                    temp.add(unit + "");
                    continue;
                }
                for (int k = 0; k < result.size(); k++) {
                    temp.add(result.get(k) + unit);
                }
            }
            result = temp;
        }
        return result;
    }
}