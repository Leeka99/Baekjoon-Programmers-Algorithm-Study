import java.io.*;
import java.util.*;

class Point{
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int r, c, t;
    public static int[][] map;
    public static int[][] tempMap;
    public static int answer = 0;

    // 방향 : 북동남서
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static Queue<Point> queue;

    public static ArrayList<Point> cleaner =new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) cleaner.add(new Point(i, j));
            }
        }

        // t초만큼 계산
        for (int i = 0; i < t; i++) {
            tempMap = new int[r][c];
            queue = new LinkedList<>();

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (map[j][k] != -1 && map[j][k] != 0) queue.add(new Point(j, k));
                }
            }

            wind();
            clean();
        }

        check();

        // 미세먼지 양 출력
        System.out.println(answer);
    }

    // 미세먼지 확산 함수 : bfs 이용
    public static void wind() {
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int currX = curr.x;
            int currY = curr.y;
            int cnt = 0;
            int currN = map[currX][currY];
            int nextN = currN / 5;
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (canGo(nextX, nextY) && map[nextX][nextY] != -1) {
                    cnt++;
                    tempMap[nextX][nextY] += nextN;
                }
            }

            tempMap[currX][currY] += currN - (nextN * cnt);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = tempMap[i][j];
            }
        }

        for (Point p : cleaner) {
            map[p.x][p.y] = -1;
        }
    }

    // 공기청정기 통합 함수
    public static void clean() {
        upClean();
        downClean();
    }

    // 위쪽 공기청정 함수
    public static void upClean() {
        Point upCleaner = cleaner.get(0);
        int x = upCleaner.x;

        // 위에서 아래로 이동
        for (int i = x - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        // 2. 왼쪽에서 오른쪽 이동
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        // 3. 위로 이동
        for (int i = 0; i < x; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        // 4. 오른쪽에서 왼쪽 이동
        for (int i = c - 1; i > 1; i--) {
            map[x][i] = map[x][i - 1];
        }

        // 공기청정기 바로 옆: 0
        map[x][1] = 0;
    }

    // 아래쪽 공기청정 함수
    public static void downClean() {
        Point downCleaner = cleaner.get(1);
        int x = downCleaner.x;

        // 1. 아래에서 위로 이동
        for (int i = x + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        // 2. 왼쪽에서 오른쪽 이동
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }

        // 3. 아래로 이동
        for (int i = r - 1; i > x; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }

        // 4. 오른쪽에서 왼쪽 이동
        for (int i = c - 1; i > 1; i--) {
            map[x][i] = map[x][i - 1];
        }

        // 공기청정기 바로 옆: 0
        map[x][1] = 0; 
    }
    
    // t초 후 map에 남아있는 미세먼지 계산 함수
    public static void check() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != -1) answer += map[i][j];
            }
        }
    }
    
    // 범위 체크 함수
    public static boolean canGo(int nextX, int nextY) {
        return 0 <= nextX && 0 <= nextY && nextX < r && nextY < c; 
    }
}
