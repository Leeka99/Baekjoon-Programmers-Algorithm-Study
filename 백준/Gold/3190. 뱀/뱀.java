import java.util.*;

public class Main {
    private static int n, apple, move, time = 0;
    private static int[][] map;
    private static int[] dx = { 0, 1, 0, -1 }; // 동,남,서,북
    private static int[] dy = { 1, 0, -1, 0 };
    private static int x = 1, y = 1, dir = 0;
    private static List<int[]> snake = new ArrayList<>();
    private static HashMap<Integer, String> diraction = new HashMap<>();

    public static void main(String[] args) {
        snake.add(new int[] { 1, 1 });
        Scanner sc = new Scanner(System.in);

        // n*n 크기로 map 초기화
        n = sc.nextInt();
        map = new int[n + 1][n + 1];

        // 사과 위치 입력받기 & 사과 있는 위치 표시
        apple = sc.nextInt();
        for (int i = 0; i < apple; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }

        // 방향 전환 횟수 저장
        move = sc.nextInt();
        for (int i = 0; i < move; i++) {
            int t = sc.nextInt();
            String d = sc.next();
            diraction.put(t, d);
        }
        sc.close();

        while (true) {
            // 시간 증가
            time++;

            // 한칸 전진
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 벽이라면 & 자신의 몸과 닿는다면 => end
            if (!canGo(nx, ny) || body(nx, ny)) {
                System.out.println(time);
                return;
            }

            // 사과 있을 때
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[] { nx, ny });
            }

            // 사과 없을 때
            else {
                snake.add(new int[] { nx, ny });
                snake.remove(0);
            }

            // 방향전환
            if (diraction.containsKey(time)) {
                // 방향전환 확인
                String s = diraction.get(time);
                if (s.equals("L"))
                    dir = (dir + 3) % 4;
                if (s.equals("D"))
                    dir = (dir + 1) % 4;
            }
            x = nx;
            y = ny;
        }
    }

    // 벽인지 확인
    private static boolean canGo(int nx, int ny) {
        return 1 <= nx && nx <= n && 1 <= ny && ny <= n;
    }

    // 자신의 몸과 닿는지 확인
    private static boolean body(int nx, int ny) {
        for (int i = 0; i < snake.size(); i++) {
            int bodyx = snake.get(i)[0];
            int bodyy = snake.get(i)[1];
            if (nx == bodyx && ny == bodyy)
                return true;
        }
        return false;
    }
}