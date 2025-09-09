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
    public static int n, m;
    public static int x, y;
    public static int nextX, nextY;
    public static int k;
    public static int[][] map;
    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{1, -1, 0, 0};

    public static int[] dice = new int[6]; // 동,서,남,북,아래,위
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // // x, y 위치에 대해 아래면 초기화
        // dice[4] = map[x][y];
        // map[x][y] = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        simulate(x, y);
    }

    public static void simulate(int x, int y) {
        while (!queue.isEmpty()) {
            int dir = queue.poll();
            int[] nextDice = dice.clone();

            // 동쪽으로 이동
            if (dir == 1) {
                nextX = x + dx[0];
                nextY = y + dy[0];

                if (canGo(nextX, nextY)) {

                    nextDice = rollEast(nextDice);

                    if (map[nextX][nextY] != 0) {
                        nextDice[4] = map[nextX][nextY];
                        map[nextX][nextY] = 0;
                    } else if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = nextDice[4];
                    }

                    x = nextX;
                    y = nextY;
                    dice = nextDice;

                    System.out.println(nextDice[5]);
                }
            }

            // 서쪽으로 이동
            if (dir == 2) {
                nextX = x + dx[1];
                nextY = y + dy[1];

                if (canGo(nextX, nextY)) {

                    nextDice = rollWest(nextDice);

                    if (map[nextX][nextY] != 0) {
                        nextDice[4] = map[nextX][nextY];
                        map[nextX][nextY] = 0;
                    } else if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = nextDice[4];
                    }

                    x = nextX;
                    y = nextY;
                    dice = nextDice;

                    System.out.println(nextDice[5]);
                }

            }

            // 북쪽으로 이동
            if (dir == 3) {
                nextX = x + dx[2];
                nextY = y + dy[2];

                if (canGo(nextX, nextY)) {

                    nextDice = rollNorth(nextDice);

                    if (map[nextX][nextY] != 0) {
                        nextDice[4] = map[nextX][nextY];
                        map[nextX][nextY] = 0;
                    } else if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = nextDice[4];
                    }

                    x = nextX;
                    y = nextY;
                    dice = nextDice;

                    System.out.println(nextDice[5]);
                }

            }

            // 남쪽으로 이동
            if (dir == 4) {
                nextX = x + dx[3];
                nextY = y + dy[3];

                if (canGo(nextX, nextY)) {

                    nextDice = rollSouth(nextDice);  

                    if (map[nextX][nextY] != 0) {
                        nextDice[4] = map[nextX][nextY];
                        map[nextX][nextY] = 0;
                    } else if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = nextDice[4];
                    }

                    x = nextX;
                    y = nextY;
                    dice = nextDice;

                    System.out.println(nextDice[5]);
                } 
            }
        }
    }

    public static boolean canGo(int nextX, int nextY) {
        if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) return true;
        return false;
    }

    public static int[] rollEast(int[] nextDice) {

        nextDice[0] = dice[4];
        nextDice[1] = dice[5];
        nextDice[4] = dice[1];
        nextDice[5] = dice[0];

        return nextDice;
    }

    public static int[] rollWest(int[] nextDice) {

        nextDice[0] = dice[5];
        nextDice[1] = dice[4];
        nextDice[4] = dice[0];
        nextDice[5] = dice[1];

        return nextDice;
    }

    public static int[] rollNorth(int[] nextDice) {

        nextDice[2] = dice[5];
        nextDice[3] = dice[4];
        nextDice[4] = dice[2];
        nextDice[5] = dice[3];

        return nextDice;
    }

    public static int[] rollSouth(int[] nextDice) {
        
        nextDice[2] = dice[4];
        nextDice[3] = dice[5];
        nextDice[4] = dice[3];
        nextDice[5] = dice[2];

        return nextDice;
    }
}
