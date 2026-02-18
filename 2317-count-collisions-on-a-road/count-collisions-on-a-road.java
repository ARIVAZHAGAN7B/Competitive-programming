class Solution {
    public int countCollisions(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left < n && s.charAt(left) == 'L') left++;
        while (right >= 0 && s.charAt(right) == 'R') right--;

        int collisions = 0;

        for (int i = left; i <= right; i++) {
            if (s.charAt(i) != 'S') collisions++;
        }

        return collisions;
    }
}
