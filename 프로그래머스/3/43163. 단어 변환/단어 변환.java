import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean exists = false;
        for (String word : words) {
            if (word.equals(target)) exists = true;
        }
        if (!exists) return answer; 
        
        boolean[] visited = new boolean[words.length];
        answer = dfs(begin, target, words, visited, 0);
        
        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
    public int dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
        
        if (begin.equals(target)) {
            return cnt;
        }
        
        int minCnt = Integer.MAX_VALUE;
        for (int index = 0; index < words.length; index++) {
            if (visited[index]) continue;
            int cnt1 = 0;
            for(int i = 0; i < begin.length(); i++) {
                if (begin.charAt(i) != words[index].charAt(i)) cnt1++;
            }
            if (cnt1 == 1) {
                visited[index] = true;
                int result = dfs(words[index], target, words, visited, cnt + 1);
                visited[index] = false;
                minCnt = Math.min(minCnt, result);
            }
        }
        return minCnt;
    }
}