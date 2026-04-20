class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            int numOfChar = s.length();
            res.append(numOfChar).append("#").append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            
            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = start + len;

            res.add(str.substring(start, end)); 
            i = end;
        }

        return res;
    }
}
