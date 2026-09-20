import java.util.*;
class Solution {
    private static int answer = 101;
    
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] graphs =  new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graphs[a].add(b);
            graphs[b].add(a);
        }
        
        for (int i = 0; i < wires.length; i++) {
            graphs[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            graphs[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            
            visited[wires[i][0]] = true;
            int a = dfs(graphs, wires[i][0], visited);
            
            visited[wires[i][1]] = true;
            int b = dfs(graphs, wires[i][1], visited);
            visited[wires[i][0]] = false;
            visited[wires[i][1]] = false;
            
            graphs[wires[i][0]].add(wires[i][1]);
            graphs[wires[i][1]].add(wires[i][0]);
            
            
            answer = Math.min(answer, Math.abs(a-b));
        }
        
        return answer;
    }
    public int dfs(ArrayList<Integer>[] graphs, int curr, boolean[] visited) {
        ArrayList<Integer> graph = graphs[curr];
        
        int cnt = 1;
        
        for (int num : graph) {
            if (visited[num]) continue;
            
            visited[num] = true;
            cnt += dfs(graphs, num, visited);
            visited[num] = false;
        }
        return cnt;
    }
}