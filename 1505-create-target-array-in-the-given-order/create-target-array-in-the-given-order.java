class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int size = nums.length;
        ArrayList<Integer> al = new ArrayList<>(size);

        for(int i=0;i<size;i++){
            int value = nums[i];
            int idx = index[i];
            al.add(idx,value);
        }

        int[] target = new int[size];

        int i=0;
        for(Integer a:al){
            target[i++] = a;
        }
        return target;
    }
}