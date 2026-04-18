class Solution {
    public int mirrorDistance(int n) {
        int n1=0;
        int ori = n;
        while(n>0){
            int temp = n%10;
            n1 = (n1 * 10) + temp;
            n/=10;
        }
        return Math.abs(ori-n1);
    }
}