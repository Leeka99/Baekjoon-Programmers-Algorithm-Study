import java.util.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = new int[]{-1,1,0,0};
    public static int[] dy = new int[]{0,0,-1,1};

    public static int number = 0;
    public static int cnt;
    public static ArrayList<Integer> answer = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    cnt = 1;
                    number++;
                    map[i][j] = number;
                    dfs(i, j);
                    answer.add(cnt);
                }
            }
        }

        System.out.println(number);

        Collections.sort(answer);
        
        for (int n : answer) {
            System.out.println(n);
        }
        
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
                continue;
            }
            if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
                continue;
            }

            map[nextX][nextY] = number;
            cnt++;

            dfs(nextX, nextY);
        }
    }
}
