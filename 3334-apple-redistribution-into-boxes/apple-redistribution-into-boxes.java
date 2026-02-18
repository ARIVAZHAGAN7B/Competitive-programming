class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = Arrays.stream(apple).sum();
        int index=0;
        int i=capacity.length-1;
        while(sum > 0){
            sum-= capacity[i];
            index++;
            i--;
            if(sum <= 0) return index;
        }
        return index;
    }
}