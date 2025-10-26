import java.util.*;
import java.io.*;

// 최소 연료 값 찾기

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < m; i++){ 
            dfs(i, 0, -1, map[0][i]);
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int history, int sum) {
        if (y == n - 1) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = dx[i] + x;
            int ny = y + 1;

            if (i == history) continue;
            if (nx < 0 || m <= nx) continue;
            dfs(nx, ny, i, sum + map[ny][nx]);
        }
    }
}
