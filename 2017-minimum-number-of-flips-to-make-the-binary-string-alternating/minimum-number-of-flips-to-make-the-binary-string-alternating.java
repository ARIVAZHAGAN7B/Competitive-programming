class Solution {
    public int minFlips(String s) {
        int n = s.length();


        if (n == 1) return 0;

        String t = s + s;
        int ans = Integer.MAX_VALUE;

        int diff1 = 0;
        int diff2 = 0;

        int left = 0;

        for (int right = 0; right < 2 * n; right++) {
            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if (t.charAt(right) != expected1) diff1++;
            if (t.charAt(right) != expected2) diff2++;

            if (right - left + 1 > n) {
                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (t.charAt(left) != leftExpected1) diff1--;
                if (t.charAt(left) != leftExpected2) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}