import java.util.*;

public class Main {
    private static int n, m, answer = 0;
    private static int[][] map;
    private static int[] dx = { 0, 1, 0, -1 }; // 가로
    private static int[] dy = { -1, 0, 1, 0 }; // 세로

    private static void test() {
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean canGo(int nx, int ny, int[][] copy) {
        if (1 > nx || 1 > ny || nx > n || ny > m)
            return false;

        if (copy[nx][ny] != 0)
            return false;

        return true;
    }

    private static int[][] spread(int[][] copy) {
        Queue<int[]> queue = new ArrayDeque<>();

        // 큐에 현재 바이러스 위치 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (copy[i][j] == 2)
                    queue.offer(new int[] { i, j });
            }
        }

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = arr[0] + dx[dir];
                int ny = arr[1] + dy[dir];
                if (canGo(nx, ny, copy)) {
                    copy[nx][ny] = 2;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }

        return copy;
    }

    private static void checkSafetyArea(int[][] copy) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (copy[i][j] == 0)
                    result += 1;
            }
        }
        answer = Math.max(answer, result);
    }

    private static int[][] copyMap() {
        int[][] copy = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    private static void dfs(int cnt) {

        // 벽이 3개 세워졌다면
        if (cnt == 3) {

            // 배열 복사
            int[][] copy = copyMap();

            // 바이러스 퍼트리기
            copy = spread(copy);

            // 안전구역 체크
            checkSafetyArea(copy);

            return;
        }

        // 벽세우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 벽이거나 바이러스라면 패스
                if (map[i][j] == 1 || map[i][j] == 2)
                    continue;
                map[i][j] = 1;
                dfs(cnt + 1);

                // 백트래킹
                map[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][m + 1];

        // 연구실 초기 형태
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
        dfs(0);
        System.out.println(answer);
    }
}