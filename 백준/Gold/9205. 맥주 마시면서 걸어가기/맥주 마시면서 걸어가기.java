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
    public static int t, n, distance;
    public static int homeX, homeY;
    public static int storeX, storeY;
    public static int rackX, rackY;
    public static Point[] locations;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            locations = new Point[n + 2];
            visited = new boolean[n + 2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            locations[0] = new Point(homeX, homeY);

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                storeX = Integer.parseInt(st.nextToken());
                storeY = Integer.parseInt(st.nextToken());
                locations[j + 1] = new Point(storeX, storeY);
            }

            st = new StringTokenizer(br.readLine());
            rackX = Integer.parseInt(st.nextToken());
            rackY = Integer.parseInt(st.nextToken());
            locations[n + 1] = new Point(rackX, rackY);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visited[0] = true;

            boolean happy = false;

            while (!queue.isEmpty()) {
            int curr = queue.poll();
            Point p = locations[curr];

            if (curr == n + 1) {
                happy = true;
                break;
            }
            // 이동 가능한 모든 위치 확인
            for (int j = 1; j <= n + 1; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(p.x - locations[j].x) + Math.abs(p.y - locations[j].y);
                    if (dist <= 1000) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }            
        }

            System.out.println(happy ? "happy" : "sad");
        }
    }
}
