class Solution {

    public void Sort(int[][] arr) {
        int row = arr.length;

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < row - 1 - i; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[0][0];

        Sort(intervals);

        ArrayList<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][2]);
    }
}
