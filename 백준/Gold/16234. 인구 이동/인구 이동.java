import java.util.*;

public class Main {
    private static int n, l, r, answer = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }

    private static boolean minus(int x1, int x2) {
        int num = Math.abs(x1 - x2);
        return l <= num && num <= r;
    }

    private static List<int[]> bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> temp = new ArrayList<>();
        queue.offer(new int[] { x, y });
        temp.add(new int[] { x, y });
        visited[x][y] = true;
        int sum = map[x][y];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = curr[0] + dx[dir];
                int ny = curr[1] + dy[dir];
                if (!canGo(nx, ny) || visited[nx][ny])
                    continue;
                if (minus(map[curr[0]][curr[1]], map[nx][ny])) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] { nx, ny });
                    temp.add(new int[] { nx, ny });
                    sum += map[nx][ny];
                }
            }
        }
        int avg = sum / temp.size();

        for (int[] p : temp) {
            map[p[0]][p[1]] = avg;
        }

        return temp;
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        // 인구이동
        while (true) {
            visited = new boolean[n][n];
            boolean moved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> temp = bfs(i, j);
                        if (temp.size() > 1) {
                            moved = true;
                        }
                    }
                }
            }

            // 연합 없었다면 정지
            if (!moved) {
                break;
            }
            answer++;
        }

        // 최종 답
        System.out.println(answer);
    }
}