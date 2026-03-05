class Solution {
    public int minOperations(String s) {
        int count1 = 0; // operations to make string start with '0'
        int count2 = 0; // operations to make string start with '1'
        
        for (int i = 0; i < s.length(); i++) {
            // For pattern starting with '0': even indices should be '0', odd indices should be '1'
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') count1++;
            } else {
                if (s.charAt(i) != '1') count1++;
            }
            
            // For pattern starting with '1': even indices should be '1', odd indices should be '0'
            if (i % 2 == 0) {
                if (s.charAt(i) != '1') count2++;
            } else {
                if (s.charAt(i) != '0') count2++;
            }
        }
        
        return Math.min(count1, count2);
    }
}