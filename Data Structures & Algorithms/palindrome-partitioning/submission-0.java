class Solution {
    private List<List<String>> res;
    private List<String> part;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        part = new ArrayList<>();
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String curr = s.substring(start, i + 1);

            if (isPalindrome(curr)) {
                part.add(curr);
                backtrack(s, i + 1);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
