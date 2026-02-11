class Solution {

    static int index = 0;

    public static String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private static String decode(String s) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');   // handle multi-digit numbers
                index++;
            } 
            else if (ch == '[') {
                index++;                      // skip '['
                String inner = decode(s);     // recursive call
                result.append(inner.repeat(num));
                num = 0;                      // reset number
            } 
            else if (ch == ']') {
                index++;                      // skip ']'
                return result.toString();     // end current recursion level
            } 
            else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }
}
