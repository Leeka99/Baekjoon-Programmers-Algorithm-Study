import java.io.*;
import java.util.*;

public class Main {
    static int n, q, num; // n : 맵 크기(제곱수), q : 파이어스톰 횟수
    static int[][] map;
    static int[] l; // 마법사 상어가 시전한 단계
    
    // 북쪽부터. 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        num = (int)Math.pow(2, n);
        map = new int[num][num];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        l = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        // 파이어스톰 q번만큼 실행
        for (int i = 0; i < q; i++) {
            fireStorm(l[i]);
        }

        // 답안 출력
        // 답안1) map에 남아있는 얼음 합 출력
        System.out.println(countIce());
        // 답안2) 가장 큰 덩어리가 차지하는 칸의 개수 출력
        System.out.println(bigIce());
    }
    
    // 파이어스톰
    static void fireStorm(int level) {
        // level 0이면 파이어스톰 안함. 90도 회전 불필요
        if (level > 0) rotate(level);
        melt();
    }

    // 부분 격자 회전. 90도 방향으로 시계방향 회전 
    static void rotate(int level) {
        int size = (int) Math.pow(2, level); // 부분 격자 크기
        int[][] newMap = new int[num][num];

        for (int x = 0; x < num; x += size) {
            for (int y = 0; y < num; y += size) {
                // size x size 부분 격자 회전
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        newMap[x + j][y + size - 1 - i] = map[x + i][y + j];
                    }
                }
            }
        }
        map = newMap;
    }

    // 얼음 녹이기
    static void melt() {
        List<int[]> meltList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (map[i][j] == 0) continue;
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (!canGo(nx, ny)) continue;
                    if (map[nx][ny] > 0) cnt++;
                }
                if (cnt < 3) meltList.add(new int[]{i, j});
            }
        }

        for (int[] p : meltList) {
            map[p[0]][p[1]]--;
        }
    }

    // 얼음 합
    static int countIce() {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    // 가장 큰 얼음 덩어리
    static int bigIce() {
        boolean[][] visited = new boolean[num][num];
        int maxSize = 0;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    int size = bfs(i, j, visited);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    // BFS 탐색
    static int bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];
                if (canGo(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }

    // 범위 확인
    static boolean canGo(int x, int y) {
        return 0 <= x && 0 <= y && x < num && y < num;
    }
}