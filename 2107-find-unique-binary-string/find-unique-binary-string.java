class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int size = nums[0].length();

        int allConfig = 1 << size;

        Set<String> set = new HashSet<>();
        for(String num : nums){
            set.add(num);
        }

        for(int i=0;i<allConfig;i++){
            String s = Integer.toBinaryString(i);

            while(s.length() < size){
                s = "0" + s;
            }

            if(!set.contains(s)) return s;
        }
        return "";
    }
}