import java.io.*;
import java.util.*;

public class Main {
    static int n, m; // n : 맵 크기 , m : 활성 바이러스 개수
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Point> arr = new ArrayList<>(); // 전체 바이러스 후보 위치
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Virus {
        int x, y, t;
        Virus(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) arr.add(new Point(i, j));
            }
        }

        // arr에서 m개 고르는 조합 실행
        comb(0, 0, new Point[m]);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // 조합
    static void comb(int start, int depth, Point[] selected) {
        if (depth == m) {
            bfs(selected);
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            selected[depth] = arr.get(i);
            comb(i + 1, depth + 1, selected);
        }
    }

    // BFS
    static void bfs(Point[] active) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[][] clone = new int[n][n];

        // map 깊은 복사
        for (int i = 0; i < n; i++) {
            clone[i] = map[i].clone();
        }

        // 선택된 m개 활성 바이러스 큐에 넣기
        for (Point p : active) {
            queue.add(new Virus(p.x, p.y, 0));
            visited[p.x][p.y] = true;
        }

        int time = 0;
        while (!queue.isEmpty()) {
            Virus curr = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (!canGo(nx, ny) || visited[nx][ny] || clone[nx][ny] == 1) continue;

                visited[nx][ny] = true;

                if (clone[nx][ny] == 0) { // 빈 칸이면 시간 증가
                    queue.add(new Virus(nx, ny, curr.t + 1));
                    time = Math.max(time, curr.t + 1);
                } else if (clone[nx][ny] == 2) { // 비활성 바이러스면 시간 그대로
                    queue.add(new Virus(nx, ny, curr.t + 1));
                }
            }
        }

        if (check(visited)) {
            answer = Math.min(answer, time);
        }
    }

    // 모든 빈 칸에 퍼졌는지 확인
    static boolean check(boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 범위 확인
    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
