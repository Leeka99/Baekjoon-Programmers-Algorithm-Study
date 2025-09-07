import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1);
        System.out.println(answer);
    }

    public static void dfs(int depth, int start) {
        
        if (depth == n / 2) {
            int teamA = 0;
            int teamB = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[i] && visited[j]) teamA += map[i][j];
                    if (!visited[i] && !visited[j]) teamB += map[i][j];
                }
            }
            answer = Math.min(answer, Math.abs(teamA - teamB));
        }

        for (int i = start; i <= n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}
