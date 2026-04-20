class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;

        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> dq.push(')');
                case '{' -> dq.push('}');
                case '[' -> dq.push(']');
                default -> {
                    if (dq.isEmpty() || dq.pop() != c) return false;
                }
            }
        }

        return dq.isEmpty();
    }
}
