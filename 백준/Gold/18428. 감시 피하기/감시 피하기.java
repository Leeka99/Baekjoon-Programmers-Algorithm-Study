import java.util.*;

public class Main {
    private static int n;
    private static char[][] map;
    private static ArrayList<int[]> teacher = new ArrayList<>();
    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static void test() {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean canGo(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < n && ny < n;
    }

    private static boolean watch(int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (!canGo(x, y))
                return true;
            if (map[x][y] == 'O')
                return true;
            if (map[x][y] == 'S')
                return false;
        }
    }

    private static boolean findStudent() {
        for (int i = 0; i < teacher.size(); i++) {
            int x = teacher.get(i)[0];
            int y = teacher.get(i)[1];

            for (int dir = 0; dir < 4; dir++) {
                if (!watch(x, y, dir)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int cnt) {
        // 벽 3개 세워졌다면 학생 보이는지 찾기
        if (cnt == 3)
            return findStudent();

        // 백트래킹
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 'T' && map[i][j] != 'S' && map[i][j] != 'O') {
                    map[i][j] = 'O';
                    if (dfs(cnt + 1))
                        return true;
                    map[i][j] = 'X';
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().replace(" ", "");
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'T') {
                    teacher.add(new int[] { i, j });
                }
                map[i][j] = c;
            }
        }
        sc.close();
        // test();

        // 벽세우기 + 학생 보이는지 확인
        boolean bool = dfs(0);
        if (bool)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
