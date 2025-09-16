import java.io.*;
import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] map;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static boolean[] selected;

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
                if (map[i][j] == 1) houses.add(new Point(i, j));
                if (map[i][j] == 2) chickens.add(new Point(i, j));
            }
        }

        selected = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    // 치킨집 조합 고르기
    static void dfs(int idx, int count) {
        
        if (count == m) {
            answer = Math.min(answer, distance());
            return;
        }

        if (idx == chickens.size()) return;

        // 선택 O
        selected[idx] = true;
        dfs(idx + 1, count + 1);

        // 선택 X
        selected[idx] = false;
        dfs(idx + 1, count);
    }

    // 도시의 치킨 거리 계산
    static int distance() {
        int sum = 0;
        for (Point house : houses) {
            int dist = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    Point chicken = chickens.get(i);
                    dist = Math.min(dist, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
                }
            }
            sum += dist;
        }
        return sum;
    }
}
