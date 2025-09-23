import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static ArrayList<Fish> fish;
    // 아기상어 현재 위치 저장
    static Point shark; 
    static int babySize = 2;
    static int levelBar = 0;
    static int answer = 0;

    // 북쪽부터 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 거리계산을 위한 Queue -> 아기상어 좌표를 저장
    static Queue<Fish> queue;
    static boolean[][] visited;

    // 물고기마다 가장 가까운 거리를 계산하기 위한 정보 저장
    static class Fish{
        int x, y, d; // x:fish x좌표, y:fish 좌표, d는 아기상어와의 거리
        Fish(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 입력정보 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) { 
                int n = Integer.parseInt(st.nextToken());
                if (n == 9) {
                    shark = new Point(i, j);
                    map[i][j] = 0;
                }
                else {
                    map[i][j] = n;
                }
            }
        }

        start();
    }

    // 아기상어-> 물고기 최단거리 계산
    static void bfs() {
        while (!queue.isEmpty()) {
            Fish curr = queue.poll();
            int cx = curr.x;
            int cy = curr.y;

            // 먹을 수 있는 물고기라면 저장
            if (map[cx][cy] < babySize && map[cx][cy] != 0) {
                Fish f = new Fish(cx, cy, curr.d);
                fish.add(f);
            }


            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny) && map[nx][ny] <= babySize && !visited[nx][ny]) {
                    queue.add(new Fish(nx, ny, curr.d + 1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 범위 제한 함수
    static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }

    // 먹이 정보 저장
    static int findFish() {
        fish = new ArrayList<>();
        queue = new LinkedList<>();
        visited = new boolean[n][n];
        queue.add(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;
        bfs();

        // 먹이 없음
        if (fish.size() == 0) return 0;

        // 먹이 2 이상이면 거리순으로 정렬(우선순위 : 거리, 행 작은 순, 열 작은 순)
        if (fish.size() > 1) {
            fish.sort((a,b) -> {
                if (a.d != b.d) return a.d - b.d; // 오름차순
                if (a.x != b.x) return a.x - b.x; // 오름차순
                return a.y - b.y; // 오름차순
            });
            return 2;
        }

        // 먹이 1개
        return 1;
    }

    // 전체 함수 총괄
    static void start() {
        while (true) {
            int number = findFish();

            if (number == 0) break;
            if (number > 0) move();
        }
        
        System.out.println(answer);
    }

    // 아기상어 먹이 먹으러 이동
    static void move() {
        answer += fish.get(0).d;
        shark.x = fish.get(0).x;
        shark.y = fish.get(0).y;

        levelBar++;
        
        if (levelBar == babySize) {
            babySize++;
            levelBar = 0;
        }
        map[shark.x][shark.y] = 0;
    }
}