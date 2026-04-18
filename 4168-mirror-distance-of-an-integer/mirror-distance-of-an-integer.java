class Solution {
    public int mirrorDistance(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String a = sb.toString();
        Integer n1 = Integer.parseInt(a);
        System.out.print(n1);
        return Math.abs(n-n1);
    }
}