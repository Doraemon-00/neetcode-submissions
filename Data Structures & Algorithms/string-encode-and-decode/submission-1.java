class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            int length = s.length();
            res.append(length).append(";").append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != ';') {
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


