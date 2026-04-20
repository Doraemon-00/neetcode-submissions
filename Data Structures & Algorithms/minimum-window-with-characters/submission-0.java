class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tChar = new HashMap<>();

        for (char c : t.toCharArray()) {
            tChar.put(c, tChar.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = tChar.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tChar.containsKey(c) && window.get(c).equals(tChar.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (tChar.containsKey(leftChar) && window.get(leftChar) < (tChar.get(leftChar))) {
                    have--;
                }

                l++;                
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1); 

    }
}
