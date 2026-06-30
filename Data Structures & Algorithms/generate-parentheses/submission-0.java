class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(0, 0, n, curr, res);
        return res;
    }

    private void backtrack(int open, int close, int n, StringBuilder curr, List<String> res) {
        if (open == close && open == n) {
            res.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append('(');
            backtrack(open + 1, close, n, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(')');
            backtrack(open, close + 1, n, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
