import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] map;
    public static boolean[][] cloud;
    public static Queue<Point> input = new LinkedList<>();
    public static Queue<Point> rain = new LinkedList<>();
    
    // 방향이동 <- 시작 , 대각선 포함
    public static int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    public static int answer = 0;

    static class Point {
        int a, b;
        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cloud = new boolean[n][n];

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            input.add(new Point(x, y));
        }

        // 초기 비구름 생성
        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;
        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;

        // 주어진 이동횟수만큼 반복
        while (!input.isEmpty()) {
            Point curr = input.poll();
            int dir = curr.a - 1;
            int times = curr.b;

            // 구름 이동
            moveCloud(dir, times);
            rain();
            copyWaterMasic();
            createCloud();
        }

        calTotalWaterAmount();

        System.out.println(answer);

    }
    // 구름 이동 함수
    public static void moveCloud(int dir, int times) {
        boolean[][] temp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    int x = (i + dx[dir] * times) % n;
                    int y = (j + dy[dir] * times) % n;
                    if (x < 0) x += n;
                    if (y < 0) y += n;
                    temp[x][y] = true;
                }
            }
        }
        cloud = temp;
    }

    // 비 내리는 함수
    public static void rain() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    map[i][j]++;
                    rain.add(new Point(i, j));
                }
            }
        }
    }

    // 물 복사 마법 함수
    public static void copyWaterMasic() {
        while (!rain.isEmpty()) {
            int cnt = 0; // 가능한 대각선 수 확인
            Point curr = rain.poll();
            int currX = curr.a;
            int currY = curr.b;

            // 대각선 4방향 확인
            for (int i = 1; i < 8; i+=2) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (canGo(nextX, nextY) && map[nextX][nextY] > 0) cnt++;
            }

            map[currX][currY] += cnt;
        }
        
    }

    // 구름 생성 함수
    public static void createCloud() {
        boolean[][] temp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!cloud[i][j] && map[i][j] >= 2) {
                    temp[i][j] = true;
                    map[i][j] -= 2;
                }
            }
        }
        cloud = temp;
    }

    // 최종 물양 계산 함수
    public static void calTotalWaterAmount() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += map[i][j];
            }
        }
    }

    // 범위 확인 함수 
    public static boolean canGo(int nextX, int nextY) {
        return 0 <= nextX && 0 <= nextY && nextX < n && nextY < n;
    }
}
