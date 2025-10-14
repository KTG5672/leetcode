class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    void generate(List<String> list, String current, int left, int right, int max) {
        if (left == max && right == max) {
            list.add(current);
            return;
        } else if (left == max) {
            generate(list, current + ")", left, right + 1, max);
            return;
        }

        if (left < max) {
            generate(list, current + "(", left + 1, right, max);
        }
        if (left > right) {
            generate(list, current + ")", left, right + 1, max);
        }
    }
}