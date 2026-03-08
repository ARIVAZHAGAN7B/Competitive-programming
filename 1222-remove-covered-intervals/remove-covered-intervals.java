class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        for(int arr[]:intervals){
            System.out.println(arr[0] +" "+ arr[1]);
        }

        int size = intervals.length;

        int merged = 0;

        for (int i = 0; i < size - 1; i++) {

            int a = intervals[i][0];
            int b = intervals[i][1];

            if (intervals[i + 1][0] >= a) {
                while (i < size - 1 && b >= intervals[i + 1][1]) {
                    i++;
                    merged++;
                }
            }
        }

        return size - merged;
    }
}