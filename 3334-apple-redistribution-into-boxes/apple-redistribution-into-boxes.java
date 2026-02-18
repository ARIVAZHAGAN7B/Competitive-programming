class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = Arrays.stream(apple).sum();
        int index=0;
        for(int i=0;i<capacity.length/2;i++){
            int temp = capacity[i];
            capacity[i] = capacity[capacity.length-i-1];
            capacity[capacity.length-i-1] = temp;
        }
        while(sum > 0){
            sum-= capacity[index];
            index++;
            if(sum <= 0) return index;
        }
        return index;
    }
}