class Solution {
    private List<String> res = new ArrayList<>();;
    private String[] digitsToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return res;   
        backtrack(digits, "", 0);
        return res;
    }

    private void backtrack(String digits, String curr, int i) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        String chars = digitsToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(digits, curr + c, i + 1);
        }
    }
}
