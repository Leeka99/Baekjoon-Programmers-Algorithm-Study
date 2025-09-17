import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;

    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 }; 
    static int[] dy = { 0, 0, -1, 1 };

    static class State {
        int rx, ry, bx, by, depth;
        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static class Result {
        int x, y, dist;
        boolean hole;
        Result(int x, int y, int dist, boolean hole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.hole = hole;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i; ry = j;
                    map[i][j] = '.';
                }
                if (map[i][j] == 'B') {
                    bx = i; by = j;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        queue.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            // 10번 이내만 허용
            if (cur.depth >= 10) break; 

            for (int d = 0; d < 4; d++) {
                Result r = moveBall(cur.rx, cur.ry, d);
                Result b = moveBall(cur.bx, cur.by, d);

                // 파란 구슬 빠짐 -> 실패
                if (b.hole) continue;

                // 빨간 구슬만 성공
                if (r.hole) return cur.depth + 1;

                // 겹침 처리
                if (r.x == b.x && r.y == b.y) {
                    if (r.dist > b.dist) {
                        r.x -= dx[d];
                        r.y -= dy[d];
                    } else {
                        b.x -= dx[d];
                        b.y -= dy[d];
                    }
                }

                if (!visited[r.x][r.y][b.x][b.y]) {
                    visited[r.x][r.y][b.x][b.y] = true;
                    queue.add(new State(r.x, r.y, b.x, b.y, cur.depth + 1));
                }
            }
        }
        return -1;
    }

    // 구슬 이동 함수
    static Result moveBall(int x, int y, int dir) {
        int dist = 0;
        boolean hole = false;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (map[nx][ny] == '#') break;
            x = nx;
            y = ny;
            dist++;
            if (map[nx][ny] == 'O') {
                hole = true;
                break;
            }
        }
        return new Result(x, y, dist, hole);
    }
}
