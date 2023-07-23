class Solution {
    public int solution(int a, int b) {
        int c = Integer.parseInt(Integer.toString(a)+Integer.toString(b));
        int d = 2*a*b;
        return c>=d? c:d;
    }
}