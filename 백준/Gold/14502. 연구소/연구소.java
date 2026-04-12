import java.util.*;

public class Main {
    private static int n, m, answer = 0;
    private static int[][] map;
    private static int[][] copy;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static boolean[][] visited;

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < m;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;

        // 바이러스 퍼트리기
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curr[0] + dx[dir];
                int ny = curr[1] + dy[dir];
                // map 범위 내 && 벽 아니라면 && 방문 안 했다면 퍼트리기
                if (canGo(nx, ny) && copy[nx][ny] != 1 && !visited[nx][ny]) {
                    copy[nx][ny] = 2;
                    visited[nx][ny] = true;
                    queue.offer(new int[] { nx, ny });
                }

            }
        }

    }

    private static void dfs(int cnt, int sx, int sy) {
        // 벽 3개 세워졌다면
        if (cnt == 3) {
            copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                copy[i] = map[i].clone();
            }
            visited = new boolean[n][m];
            // 바이러스 퍼트리기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 만약 바이러스 칸이라면 bfs 진행
                    if (map[i][j] == 2 && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            // 안전영역 최대값 확인하기
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 0)
                        sum += 1;
                }
            }

            answer = Math.max(answer, sum);

            return;
        }

        // 백트래킹
        for (int i = sx; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 중복 탐색 제거 -> ncr 유지
                if (i == sx && j < sy)
                    continue;

                // 만약 빈칸이라면 벽 세우기
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1, i, j + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // 벽 세우기
        dfs(0, 0, 0);

        // 안전영역 최대값 출력
        System.out.println(answer);
    }
}