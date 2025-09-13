import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int x, y, d, g;
    public static int[][] map = new int[101][101];
    
    // 이전세대의 드래곤 커브 방향 기억
    public static ArrayList<Integer> memory;

    public static int answer = 0;

    // 동북서남
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            memory = new ArrayList<>();
            dragon(x, y, d, g);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isSqure(i, j)) answer++;
            }
        }

        System.out.println(answer);
    }

    // 한개의 드래곤커브에 대한 큰 틀
    public static void dragon(int x, int y, int d, int g) {
        memory.add(d);
        saveDir(g);
        draw(x, y);
    }

    // 방향 저장
    public static void saveDir(int g) {
        for (int i = 1; i <= g; i++) {
            int size = memory.size();
            for (int k = size - 1; k >= 0; k--) {
                int dir = (memory.get(k) + 1) % 4;
                memory.add(dir);
            }
        }
    }

    // 드래곤커브 그리기
    public static void draw(int x, int y) {

        map[x][y] = 1;
        
        int currX = x;
        int currY = y; 

        for (int dir : memory) {
            int nextX = currX + dx[dir];
            int nextY = currY + dy[dir];
            
            if (canGo(nextX, nextY)) {
                map[nextX][nextY] = 1;
                currX = nextX;
                currY = nextY;
            }
        }
    }

    // 갈 수 있는지 확인
    public static boolean canGo(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < 101 && nextY < 101;
    }

    // 정사각형 안에 드래곤커브 있는지 확인
    public static boolean isSqure(int x, int y) {
        return map[x][y] == 1 && map[x+1][y] == 1 && map[x][y+1] == 1 && map[x+1][y+1] == 1;
    }
}
