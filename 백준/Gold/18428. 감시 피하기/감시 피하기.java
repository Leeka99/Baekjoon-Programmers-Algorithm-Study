import java.util.*;

class Teacher {
    private int x;
    private int y;

    public Teacher(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    private static int n;
    private static char[][] map;
    private static ArrayList<Teacher> t = new ArrayList<>();
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

    private static boolean findStudent() {

        for (Teacher teacher : t) {
            for (int dir = 0; dir < 4; dir++) {
                int x = teacher.getX();
                int y = teacher.getY();
                while (true) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (!canGo(nx, ny))
                        break;
                    if (map[nx][ny] == 'S')
                        return false;
                    if (map[nx][ny] == 'O')
                        break;

                    x = nx;
                    y = ny;
                }

            }
        }
        return true;
    }

    private static boolean dfs(int cnt) {
        // 벽 3개 세워졌다면 탐색
        if (cnt == 3) {
            return findStudent();
        }

        // 기둥 세우기, 백트래킹
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    boolean bool = dfs(cnt + 1);
                    if (bool)
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
                // 선생님 위치 저장
                if (c == 'T')
                    t.add(new Teacher(i, j));
                map[i][j] = s.charAt(j);
            }
        }
        sc.close();

        boolean bool = false;
        bool = dfs(0);

        if (bool)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
