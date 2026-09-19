import java.util.*;
class Solution {
    private HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        for (int i = 1; i <= arr.length; i++) {
            dfs(i, "", arr, visited);
        }
        answer = set.size();
        return answer;
    }
    public void dfs(int goal, String s, char[] arr, boolean[] visited) {
        if (goal == s.length()) {
            int num = Integer.parseInt(s);
            if (num == 0 || num == 1) return;
            for (int i = 2; i*i <= num; i++) {
                if (num % i == 0) return;
            }
            set.add(num);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(goal, s + arr[i], arr, visited);
            visited[i] = false;
        }
    }
}