import java.util.*;

public class Main {
    private static int n, k, targetX, targetY, s;
    private static PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
        if (a[3] != b[3]) {
            return a[3] - b[3];
        }
        return a[0] - b[0];
    });
    private static int[][] map;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static void test() {
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean canGo(int nx, int ny) {
        if (1 > nx || 1 > ny || nx > n || ny > n)
            return false;

        if (map[nx][ny] != 0)
            return false;

        return true;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int target = arr[0];
            int x = arr[1];
            int y = arr[2];
            int time = arr[3];

            // s초 후 (targetX, targetY) 값 확인
            if (time == s)
                break;

            // 상하좌우 바이러스 퍼트리기
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (canGo(nx, ny)) {
                    map[nx][ny] = target;
                    queue.offer(new int[] { target, nx, ny, time + 1 });
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // map 초기화
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                // queue에 1 ~ k까지 순서대로 저장
                if (num != 0) {
                    queue.offer(new int[] { num, i, j, 0 });
                }
            }
        }

        s = sc.nextInt();
        targetX = sc.nextInt();
        targetY = sc.nextInt();
        sc.close();

        bfs();
        System.out.println(map[targetX][targetY]);

    }
}
