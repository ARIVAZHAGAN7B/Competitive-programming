class Solution {
    public int[] leftRightDifference(int[] nums) {

        int size = nums.length;

        int[] rsum = new int[size];
        int[] lsum = new int[size];
        Arrays.fill(rsum,0);
        Arrays.fill(lsum,0);

        for(int i=1;i<size;i++){
            lsum[i] = lsum[i-1] + nums[i-1];
        }

        for(int i=size-2;i>=0;i--){
            rsum[i] = rsum[i+1] + nums[i+1];
        }

        int arr[] = new int[size];
        Arrays.fill(arr, 0);
        for(int i=0;i<size;i++) {
            arr[i] = Math.abs(lsum[i] - rsum[i]);
        }

        return arr;
    }
}