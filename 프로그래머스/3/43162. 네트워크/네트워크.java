import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<Integer>[] graphs = new ArrayList[n];
         
        // dfs 탐색을 위한 인접 리스트 만들기
        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 0) continue;
                if (i == j) continue;
                graphs[i].add(j);
            }
        }
        
        // 네트워크 개수 탐색
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, graphs, visited);
            answer++;
        }
        return answer;
    }
    public void dfs(int index, ArrayList<Integer>[] graphs, boolean[] visited) {
        ArrayList<Integer> graph = graphs[index];
            for (int number : graph) {
                if (visited[number]) continue;
                visited[number] = true;
                dfs(number, graphs, visited);
            }
    } 
}