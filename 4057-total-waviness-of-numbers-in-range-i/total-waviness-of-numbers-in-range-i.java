class Solution {
    public int count_valley(String str){
        int count = 0;
        for(int i=1;i<str.length()-1;i++){
            int num1 = str.charAt(i-1) - '0';
            int num2 = str.charAt(i) - '0';
            int num3 = str.charAt(i+1) - '0';
            if(num2 < num1 && num2 < num3) count++;
        }
        return count;
    }
    public int count_peak(String str){
        int count = 0;
        for(int i=1;i<str.length()-1;i++){
            int num1 = str.charAt(i-1) - '0';
            int num2 = str.charAt(i) - '0';
            int num3 = str.charAt(i+1) - '0';
            if(num2 > num1 && num2 > num3) count++;
        }
        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i=num1;i<=num2;i++){
            String num = ""+i;
            count += count_peak(num);
            count += count_valley(num);
        }
        return count;
    }
}