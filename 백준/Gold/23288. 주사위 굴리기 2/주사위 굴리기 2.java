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
    public static int n, m, k;
    public static int[][] map;
    // 북,동,남,서,위,아래
    public static int[] dice = new int[]{2,3,5,4,1,6};

    // 주사위 방향
    public static int dir = 1;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int currX = 1;
    public static int currY = 1;

    public static int answer = 0;

    public static Queue<Point> queue;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            move();
            moveDice();
            score();
            changeDir();
        }

        // 정답 출력
        System.out.println(answer);
    }

    // 이동 함수
    public static void move() {
        int nextX = currX + dx[dir];
        int nextY = currY + dy[dir];
        
        if (!canGo(nextX, nextY)) {
            dir = (dir + 2) % 4;
            nextX = currX + dx[dir];
            nextY = currY + dy[dir];
        }

        currX = nextX;
        currY = nextY;
        
    }

    // 주사위 이동 함수
    public static void moveDice() {
        int[] copyDice = new int[6];

        // 북쪽 이동
        if (dir == 0) {
            copyDice[5] = dice[0];
            copyDice[4] = dice[2];
            copyDice[0] = dice[4];
            copyDice[2] = dice[5];

            copyDice[1] = dice[1];
            copyDice[3] = dice[3];
        }

        // 동쪽 이동
        else if (dir == 1) {
            copyDice[5] = dice[1];
            copyDice[4] = dice[3];
            copyDice[1] = dice[4];
            copyDice[3] = dice[5];

            copyDice[0] = dice[0];
            copyDice[2] = dice[2];
        }

        // 남쪽 이동
        else if (dir == 2) {
            copyDice[4] = dice[0];
            copyDice[5] = dice[2];
            copyDice[2] = dice[4];
            copyDice[0] = dice[5];

            copyDice[1] = dice[1];
            copyDice[3] = dice[3];
        }

        // 서쪽 이동
        else if (dir == 3) {
            copyDice[4] = dice[1];
            copyDice[5] = dice[3];
            copyDice[3] = dice[4];
            copyDice[1] = dice[5];

            copyDice[0] = dice[0];
            copyDice[2] = dice[2];
        }
        dice = copyDice;
    }

    // 점수획득 함수
    public static void score() {
        int b = map[currX][currY];
        boolean[][] visited = new boolean[n + 1][m + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(currX, currY));
        visited[currX][currY] = true;
        int c = 1;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                if (canGo(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == b) {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                    c++;
                }
            }
        }
        answer += b * c;
    }
    
    // 방향결정 함수
    public static void changeDir() {
        // 90도 시계방향 회전
        if (dice[5] > map[currX][currY]) {
            dir = (dir + 1) % 4;
        }

        // 90도 반시계방향 회전
        if (dice[5] < map[currX][currY]) {
            dir = (dir + 3) % 4;
        }

        // 이외 경우에 값 같을 경우 변화 없으므로 생략
    }
    
    // 이동 결정 함수
    public static boolean canGo(int nextX, int nextY) {
        return nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= m; 
    }
}
