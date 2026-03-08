class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();

        int[] px = new int[n + 1];
        int[] py = new int[n + 1];

        for (int i = 0; i < n; i++) {
            px[i + 1] = px[i];
            py[i + 1] = py[i];

            char c = s.charAt(i);
            if (c == 'U') py[i + 1]++;
            else if (c == 'D') py[i + 1]--;
            else if (c == 'L') px[i + 1]--;
            else if (c == 'R') px[i + 1]++;
        }

        int totalX = px[n];
        int totalY = py[n];

        Set<String> set = new HashSet<>();

        for (int l = 0; l + k <= n; l++) {
            int r = l + k - 1;

            int dx = px[r + 1] - px[l];
            int dy = py[r + 1] - py[l];

            int finalX = totalX - dx;
            int finalY = totalY - dy;

            set.add(finalX + "," + finalY);
        }

        return set.size();
    }
}