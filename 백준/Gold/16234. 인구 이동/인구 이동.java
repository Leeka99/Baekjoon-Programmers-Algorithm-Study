import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static ArrayList<Point> contries; // 연합하는 나라 좌표 저장 
    static int p; // p : 연합 인구수.
    static int c; // c : 연합 이루고 있는 칸수
    static int answer = 0; // 인구이동 날짜 계산
    // 북쪽 시작. 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean b = true; // 연합할것이 있는지 판단
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (b) {
            boolean plusDay = false;
            b = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 방문하지 않은 칸에 대해서 연합 탐색
                    if (!visited[i][j]) {
                        queue = new LinkedList<>();
                        contries = new ArrayList<>();
                        queue.add(new Point(i, j));
                        contries.add(new Point(i, j));
                        visited[i][j] = true;
                        p = map[i][j];
                        c = 1;
                        bfs();
                    }
                    // 연합하기
                    if (c > 1) {
                        int hap  = p / c;// 인구이동 숫자 구하기
                        for (Point contry : contries) {
                            int x = contry.x;
                            int y = contry.y;
                            map[x][y] = hap;
                            plusDay = true;
                            b = true;
                        }
                    }
                }
            }
            if (plusDay) answer++;
        }

        // 답안 제출
        System.out.println(answer);
    }

    // 연합 나라 찾기 함수
    static void bfs() {
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny) && !visited[nx][ny]) {
                    int minus = Math.abs(map[cx][cy] - map[nx][ny]);
                    if (l <= minus && minus <= r) {
                        queue.add(new Point(nx, ny));
                        contries.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        p += map[nx][ny];
                        c++;
                    }
                }
            }
        }
    }
    // 범위 함수
    static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }
}
