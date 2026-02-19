class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev = 0;  // previous group length
        int strk = 1;  // current group length starts at 1 (first char)

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                strk++;              // still in the same group
            } else {
                prev = strk;         // group changed
                strk = 1;            // reset current group
            }

            if (strk <= prev) res++;
        }

        return res;
    }
}
