class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                
                HashSet<Integer> set = new HashSet<>();
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        set.add(grid[r][c]);
                    }
                }

                if (set.size() != 9) continue;

                int min = Collections.min(set);
                int max = Collections.max(set);
                if (min < 1 || max > 9) continue;

                int r1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int r2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                int r3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

                int c1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
                int c2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                int c3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];

                int d1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
                int d2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

                if (r1 == r2 && r2 == r3 &&
                    r1 == c1 && r1 == c2 && r1 == c3 &&
                    r1 == d1 && r1 == d2) {
                    count++;
                }
            }
        }
        return count;
    }
}