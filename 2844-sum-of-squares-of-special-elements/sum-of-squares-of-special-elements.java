class Solution {
    public int sumOfSquares(int[] nums) {
        int len = nums.length;
        int square = 0;
        for(int i=1; i<len+1;i++){
            if(len%i == 0){
                square += nums[i-1] * nums[i-1];
            }
        }
        return square;
    }
}