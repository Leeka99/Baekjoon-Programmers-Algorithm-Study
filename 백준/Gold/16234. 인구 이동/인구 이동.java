import java.util.*;

public class Main {

    private static int n, l, r, day = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }

    private static boolean bfs(int i, int j) {
        ArrayList<int[]> check = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { i, j });
        int sum = map[i][j], cnt = 1;
        visited[i][j] = true;
        check.add(new int[] { i, j });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (!canGo(nx, ny))
                    continue;
                if (visited[nx][ny])
                    continue;
                int temp = Math.abs(map[x][y] - map[nx][ny]);
                if (l <= temp && temp <= r) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    check.add(new int[] { nx, ny });
                    sum += map[nx][ny];
                    cnt += 1;
                }
            }
        }
        if (sum > map[i][j]) {
            // 연합 진행
            int amount = sum / cnt;
            for (int[] p : check) {
                map[p[0]][p[1]] = amount;
            }
            return true;
        } else
            return false;
    }

    private static void test() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        // s = 50*50
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();

        while (true) {
            visited = new boolean[n][n];
            boolean bool = false;

            // s = 50 * 50
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && bfs(i, j)) {
                        bool = true;
                    }
                }
            }
            if (!bool) {
                System.out.println(day);
                return;
            } else
                day += 1;
        }
    }
}