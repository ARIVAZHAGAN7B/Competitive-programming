import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; // 0=N, 1=E, 2=S, 3=W
        int x = 0, y = 0;
        int maxDist = 0;

        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;   // turn right
            } else if (command == -2) {
                dir = (dir + 3) % 4;   // turn left
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + dirs[dir][0];
                    int newY = y + dirs[dir][1];

                    if (set.contains(newX + "," + newY)) {
                        break;
                    }

                    x = newX;
                    y = newY;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}