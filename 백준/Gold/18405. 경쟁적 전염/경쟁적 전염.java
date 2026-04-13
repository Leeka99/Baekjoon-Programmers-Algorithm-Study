import java.util.*;

class Virus {
    private int x, y, index, time;

    public Virus(int x, int y, int index, int time) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.time = time;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getIndex() {
        return this.index;
    }

    public int getTime() {
        return this.time;
    }
}

public class Main {

    private static int n, k;
    private static int s, x, y;
    private static int[][] map;
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static Queue<Virus> queue = new PriorityQueue<>((a, b) -> {
        if (a.getTime() != b.getTime()) {
            return a.getTime() - b.getTime();
        }
        return a.getIndex() - b.getIndex();
    });

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            // s초 지났다면 continue
            if (s == virus.getTime())
                continue;

            // 전염시키기
            for (int dir = 0; dir < 4; dir++) {
                int nx = virus.getX() + dx[dir];
                int ny = virus.getY() + dy[dir];

                if (canGo(nx, ny) && map[nx][ny] == 0) {
                    map[nx][ny] = virus.getIndex();
                    queue.offer(new Virus(nx, ny, virus.getIndex(), virus.getTime() + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                if (num != 0) {
                    queue.offer(new Virus(i, j, num, 0));
                }
            }
        }

        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        sc.close();

        bfs();
        System.out.println(map[x - 1][y - 1]);
    }
}
