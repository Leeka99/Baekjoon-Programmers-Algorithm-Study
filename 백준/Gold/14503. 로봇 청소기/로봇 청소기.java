import java.io.*;
import java.util.*;
public class Main {

    public static int n, m, r, c, d;
    public static int number = 0;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static int[][] map;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r,c);
        System.out.println(number);
    }

    // 범위 확인 메서드
    public static boolean canGo(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        if (map[x][y] == 1 || visited[x][y]) return false;

        return true;
    }

    // DFS
    public static void dfs(int x, int y) {
        if (!visited[x][y]) {
            number++;
            visited[x][y] = true;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nextX = x + dx[d];
            int nextY = y + dy[d];
            
            if (!canGo(nextX, nextY)) continue;
            
            // 청소할 칸이 있다면 dfs 돌리기
            if (map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
                return;
            }   
        }

        // 동서남북 청소할 칸 없다면 뒤로 1칸 후진
        int backX = x - dx[d];
        int backY = y - dy[d];

        // 후진 불가라면 종료
        if (map[backX][backY] == 1) return;

        // 후진 가능하다면 dfs
        dfs(backX, backY);
    }
}
