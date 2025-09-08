import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] map;
    public static int answer = Integer.MIN_VALUE;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];

        // 입력받기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 세우기 시작
        buildWall(0);

        // 정답 출력
        System.out.println(answer);

    }

    // 벽 세우기 : DFS
    public static void buildWall(int cnt) {
        
        // 벽 3개 세웠다면 바이러스 퍼트리기 시작
        if (cnt == 3) {
            spreadVirus();
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(cnt + 1);
                    map[i][j] = 0; // 백 트래킹
                }
            }
        }
    }

    // 바이러스 퍼트리기 : BFS
    public static void spreadVirus() {
        Queue<Point> queue = new LinkedList<>();
        int[][] copy = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) copy[i] = map[i].clone();

        // 바이러스 위치 찾기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = curr.x + dx[k];
                int nextY = curr.y + dy[k];

                if (nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= m) {
                    if (copy[nextX][nextY] == 0) {
                        copy[nextX][nextY] = 2;
                        queue.add(new Point(nextX, nextY));
                    }
                }
            }
        }

        // 안전구역 확인
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (copy[i][j] == 0) sum++;
            }
        }

        answer = Math.max(answer, sum);
    }
}
