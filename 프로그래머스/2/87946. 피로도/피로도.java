import java.util.*;
class Solution {
    private static int answer = 0;
    private static ArrayList<String> check = new ArrayList<>();
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        for (int amount = 1; amount <= dungeons.length; amount++) {
            dfs(0, amount, dungeons, k, visited);
        }
        return answer;
    }
    
    public void dfs(int curr, int amount, int[][] dungeons, int k, boolean[] visited) {
        
        if (curr == amount && 0 <= k) {
            answer = amount;            
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]) {
                continue;
            }
            k -= dungeons[i][1];
            visited[i] = true;
            dfs(curr+1, amount, dungeons, k, visited);
            k += dungeons[i][1];
            visited[i] = false;
        }
    }
}