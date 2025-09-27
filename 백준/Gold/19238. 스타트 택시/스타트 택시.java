import java.io.*;
import java.util.*;

public class Main {
    static int n, m, f; // m : 맵 크기, m : 승객 수, f : 연료
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static Car carPoint;
    static ArrayList<Customer> customerPoint = new ArrayList<>();
    static boolean go = true; // 계속 운행 가능한지 확인
    static Queue<Distance> queue;
    
    // 북쪽시작. 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Distance {
        int x, y, level;
        Distance(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    static class Car {
        int x, y, f;
        Car(int x, int y, int f) {
            this.x = x;
            this.y = y;
            this.f = f;
        }
    }

    static class Customer {
        int deX, deY, arX, arY, distance;
        Customer(int deX, int deY, int arX, int arY, int distance) {
            this.deX = deX;
            this.deY = deY;
            this.arX = arX;
            this.arY = arY;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        carPoint = new Car(x, y, f);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int deX = Integer.parseInt(st.nextToken());
            int deY = Integer.parseInt(st.nextToken());
            int arX = Integer.parseInt(st.nextToken());
            int arY = Integer.parseInt(st.nextToken());

            customerPoint.add(new Customer(deX, deY, arX, arY, Integer.MAX_VALUE)); 
        }
        
        // 1. m명의 승객만큼 실행
        for (int i = 0; i < m; i++) {
            
            // 2. 현재 택시 위치에서 승객과 최단거리 찾기 (bfs)
            if (!go) break;

            go = nearCustomer();
            go = drive();
        }
        
        // 3. 최종 답 출력
        if (!go) System.out.println(-1);
        else System.out.println(carPoint.f);
    }

    // 가장 가까운 승객 찾는 함수
    static boolean nearCustomer() {
        distance = new int[n + 1][n + 1];
        distance[carPoint.x][carPoint.y] = 0;
        visited = new boolean[n + 1][n + 1];
        visited[carPoint.x][carPoint.y] = true;
        queue = new LinkedList<>();
        queue.add(new Distance(carPoint.x, carPoint.y, 0));
        bfs2();

        // 승객 - 택시 거리 저장
        for (Customer c  : customerPoint) { 
            int d = distance[c.deX][c.deY];

            if (d == 0 && !(carPoint.x == c.deX && carPoint.y == c.deY)) return false;
            
            c.distance = d;
        }

        // 가까운 거리순으로 정렬
        customerPoint.sort((a,b) -> {
            if (a.distance != b.distance) return a.distance - b.distance;
            if (a.deX != b.deX) return a.deX - b.deX;
            return a.deY - b.deY;
        });

        return true;
    }

    static void bfs2() {
        while (!queue.isEmpty()) {
            Distance curr = queue.poll();
            int cx = curr.x;
            int cy = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = curr.level + 1;
                    queue.add(new Distance(nx, ny, curr.level + 1));
                }
            }
        }
    }

    static int bfs(int x, int y) {
        while (!queue.isEmpty()) {
            Distance curr = queue.poll();
            int cx = curr.x;
            int cy = curr.y;

            if (cx == x && cy == y) return curr.level;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.add(new Distance(nx, ny, curr.level + 1));
                }
            }
        }
        return -1;
    }

    // 목적지까지 이동 함수 + 연료 채우기
    static boolean drive() {

        Customer c = customerPoint.get(0);

        // 택시 - 승객 위치러 이동 연료 소모
        carPoint.f -= c.distance;
        if (carPoint.f < 0) return false; // 연료 부족

        // 출발지 - 목적지 최단거리 계산
        visited = new boolean[n + 1][n + 1];
        visited[c.deX][c.deY] = true;
        queue = new LinkedList<>();
        queue.add(new Distance(c.deX, c.deY, 0));

        int d = bfs(c.arX, c.arY);
        if (d == -1) return false; // 목적지 도달 불가

        carPoint.f -= d;
        // 목적지 도달 실패
        if (carPoint.f < 0) return false;

        // 도달 성공 시 택시 위치 변경 + 연료 채우기
        carPoint.x = c.arX;
        carPoint.y = c.arY;
        carPoint.f += d * 2;

        // 완료된 승객은 제거
        customerPoint.remove(0);
        return true;
    }

    // 범위 확인 함수 
    static boolean canGo(int nx, int ny) {
        return 0 < nx && 0 < ny && nx <= n && ny <= n;
    }
}