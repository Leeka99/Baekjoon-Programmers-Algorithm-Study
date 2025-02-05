import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    private static int n, m; 
    private static int[][] maps;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{-1, 1, 0, 0};
    private static Queue<Pair> queue = new LinkedList<>(); 
    
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
    private static boolean canGo(int x, int y) {
        return inRange(x, y) && maps[x][y] == 1;
    }
    
    private static void push(int x, int y) {
        queue.add(new Pair(x, y));
    }
    
    private static int bfs() {
        int[][] dist = new int[n][m]; // 거리 배열
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        dist[0][0] = 1;
        push(0, 0);
        
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (canGo(nx, ny) && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1; 
                    push(nx, ny);
                    
                    if (nx == n - 1 && ny == m - 1) {
                        return dist[nx][ny];
                    }
                }
            }
        }
        
        return -1;
    }
        
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        this.maps = maps;
        
        return bfs();
    }
}
