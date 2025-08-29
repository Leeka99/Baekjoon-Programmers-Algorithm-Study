import java.io.*;
import java.util.*;

public class Main {
    public static int m;
    public static int n;
    public static int h;
    public static int[][][] map;

    public static int[] dh = new int[]{-1, 1, 0, 0, 0, 0};
    public static int[] dx = new int[]{0, 0, -1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, 0, 0, -1, 1};


    public static Queue<int[]> queue = new LinkedList<>();

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    if (number == 1) {
                        queue.add(new int[]{k, i, j});
                    }
                    map[k][i][j] = number;
                }
            }
        }

        bfs();
        System.out.println(check());
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            int currA = curr[0];
            int currB = curr[1];
            int currC = curr[2];

            for (int i = 0; i < 6; i++) {
                int nextA = currA + dh[i];
                int nextB = currB + dx[i];
                int nextC = currC + dy[i];

                if (nextA < 0 || nextB < 0 || nextC < 0 || nextA >= h || nextB >= n || nextC >= m) continue;
                if (map[nextA][nextB][nextC] != 0) continue;

                map[nextA][nextB][nextC] = map[currA][currB][currC] + 1;
                queue.add(new int[]{nextA, nextB, nextC});
            }
        }
    }

    public static int check() {
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[k][i][j] == 0) return -1;
                    answer = Math.max(answer, map[k][i][j]);
                }
            }
        }
        return answer - 1;
    }
}
