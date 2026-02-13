class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : map.keySet()) {
            if (k == 0) {
                // need at least 2 occurrences
                if (map.get(num) > 1) count++;
            } else {
                if (map.containsKey(num + k)) count++;
            }
        }

        return count;
    }
}
