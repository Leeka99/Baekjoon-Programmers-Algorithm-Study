import java.util.*;
class Solution {
    private static String dfs(String s) {
        // 1. 빈 문자열이라면 빈 문자열 반환
        if (s.isBlank()) return s;
        // 2. u,v로 분리
        String u = "";
        String v = "";
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left != 0 && right != 0 && left == right) {
                u = s.substring(0, i + 1);
                if (i < s.length() - 1) v = s.substring(i + 1, s.length());
                break;
            }
        }
        
        // 3. if u가 올바른 문자열 + v체크
        if (check(u)) return u + dfs(v);
        // 4. if u가 올바른 문자열 아니라면
        else {
            // 4-1. 빈문자열 + '('
            // 4-2. v 1.부터 수행
            // 4-3. ')' 붙이기
            String tmp = "(" + dfs(v) + ")";
            
            // 4-4. u첫,마지막 문자 제거 + 괄호 방향 모두 뒤집기
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            tmp += u;
            
            // 생성된 문자열 반환
            return tmp;
        }
            
    }
   
    private static boolean check(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) return false;
        else return true;
    }
    public String solution(String p) {
        if (check(p)) return p;
        else return dfs(p);
    }
}