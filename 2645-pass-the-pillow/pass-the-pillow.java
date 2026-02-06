class Solution {
    public int passThePillow(int n, int time) {
        int hold=1;
        int dir = 1;
        for(int i=0;i<time;i++){
            hold+=dir;
            if(hold==n || hold==1){
                dir *= -1;
            }
        }
        return hold;
    }
}