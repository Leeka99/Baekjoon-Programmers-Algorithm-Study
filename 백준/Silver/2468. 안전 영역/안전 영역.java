import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int cnt = 0;
    public static int answer = 0;
    public static int maxNumber = 0;

    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                maxNumber = Math.max(maxNumber, num);
                map[i][j] = num;
            }
        }

        for (int k = 0; k <= maxNumber; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        cnt++;
                        dfs(i, j, k);
                    }
                }
            }
            answer = Math.max(answer, cnt);
            visited = new boolean[n][n];
            cnt = 0;
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if (map[nextX][nextY] <= h || visited[nextX][nextY]) continue;

            dfs(nextX, nextY, h);
        }
    }
}