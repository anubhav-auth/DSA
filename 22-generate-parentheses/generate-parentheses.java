class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        rec(result, "", 0, 0, n);
        return result;
    }

    private void rec(List<String> strList, String curr, int op, int cl, int max) {
        if (curr.length() == max * 2) {
            strList.add(curr);
            return;
        }

        if (op < max) {
            rec(strList, curr + "(", op + 1, cl, max);
        }
        if (cl < op) {
            rec(strList, curr + ")", op, cl + 1, max);
        }
    }
}