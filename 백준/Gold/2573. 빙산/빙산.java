import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] melt;
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int cnt = 0;
    public static int sep;
        
    public static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            queue.clear();
            visited = new boolean[n][m];
            melt = new int[n][m];

            // 빙산 녹이기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                        if (map[nextX][nextY] != 0) continue;

                        melt[i][j] += 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] -= melt[i][j];
                    if (map[i][j] < 0) map[i][j] = 0;
                }
            }

            sep = 0;

            // bfs로 빙산 수 확인
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0 || visited[i][j]) continue;
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    sep++;
                    bfs();
                }
            }

            cnt++;

            // 빙산 2개 이상인지 확인
            if (sep >= 2) {
                System.out.println(cnt); 
                return;
            }

            // 빙산 다 녹았는지 확인
            boolean ice = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) {
                        ice = true;
                        break;
                    }
                }
            }
            
            if (!ice) {
                System.out.println(0);
                return;
            }
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }
}
