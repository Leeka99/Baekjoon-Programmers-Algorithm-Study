import java.util.*;
class Solution {
    
    private String seperate(String s) {
        
        if (s.isEmpty()) return "";
        
        // u,v 문자열 분리
        String u = "", v = "";
        int cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (cnt1 != 0 && cnt2 != 0 && cnt1 == cnt2) {
                v += c;
                continue;
            }
            if(c == '(') {
                u += c;
                cnt1++;
            }
            else{
                u += c;
                cnt2++;
            }
        }
        
        // u가 올바른 문자열인지 확인
        boolean bool = check(u);
           
            // 만약 u가 올바른 괄호 문자열이라면
            if (bool) {
                return u + seperate(v);
            }
            // u가 올바른 괄호 문자열이 아니라면
            else {
                String reverse = "";
                for (int i = 1; i < u.length() - 1; i++) {
                    if (u.charAt(i) == '(') reverse += ')';
                    else reverse += '(';
                }
                return "(" + seperate(v) + ")" + reverse;
            }        
    }
    private boolean check(String u) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : u.toCharArray()) {
            if (c == '(') stack.add(c);
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public String solution(String p) {
        
        return seperate(p);
        
    }
}