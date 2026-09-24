import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == maps.length - 1 && curr[1] == maps[0].length - 1) {             
                return curr[2];
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = curr[0] + dx[dir];
                int ny = curr[1] + dy[dir];
                if (!canGo(nx, ny, maps) || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, curr[2] + 1});
            }
        }
        
        return -1;
    }
    public boolean canGo(int nx, int ny, int[][] maps) {
        return 0 <= nx && 0 <= ny && nx < maps.length && ny < maps[0].length;
    }
}