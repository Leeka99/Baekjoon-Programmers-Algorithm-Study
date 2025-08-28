import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[][] visited;
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(map[n - 1][m - 1]);

    }

    public static void bfs(int x, int y) {
        queue.add(new int[] {x,y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new int[] {nextX,nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }

        }
    }
}
