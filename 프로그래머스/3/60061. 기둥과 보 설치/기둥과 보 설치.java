import java.util.*;
class Solution {
    private boolean[][] g;
    private boolean[][] b;
    ArrayList<int[]> answer = new ArrayList<>();
    
    private boolean gi(int x, int y) {
        // 보가 없다면 바닥 위인지 확인
        if (y == 0) return true;
        
        // 보의 한쪽 끝에 있는지 확인
        if ((x > 0 && b[x - 1][y]) || b[x][y]) return true;
        
        // 또 다른 기둥 위에 있는지 확인
        if (y > 0 && g[x][y-1]) return true;
        
        return false;
    }
    private boolean bo(int x, int y) {
        // 한쪽 끝이 기둥위에 있는지 확인
        if (y > 0 && (g[x][y-1] || g[x+1][y-1])) return true;
        
        // 양쪽 끝이 다른 보와 동시에 연결되는지 확인
        if ((x > 0 && b[x-1][y]) && b[x+1][y]) return true;
        
        return false;
    }
    private boolean check(int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (g[x][y] && !gi(x,y)) return false;
                if (b[x][y] && !bo(x,y)) return false;
            }
        }
        
        return true;
    }
    private void result(int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (g[x][y]) answer.add(new int[]{x,y,0});
                if (b[x][y]) answer.add(new int[]{x,y,1});
            }
        }
    }
    public ArrayList<int[]> solution(int n, int[][] build_frame) {
        g = new boolean[n+1][n+1];
        b = new boolean[n+1][n+1];
        
        // build_frame 하나씩 뽑기
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2]; // 기둥0, 보1
            int build = build_frame[i][3]; // 삭제0, 설치1
            
            // type == 1 이라면 (설치)
            if (build == 1) {
                if (type == 0 && gi(x,y)) {
                    g[x][y] = true;
                }
                if (type == 1 && bo(x,y)) {
                    b[x][y] = true;
                }
            }
            
            // type == 0 이라면 (삭제)
            if (build == 0) {
                // 기둥이라면 삭제
                if (type == 0) g[x][y] = false;
            
                // 보라면 삭제
                if (type == 1) b[x][y] = false;
                
                // 무너진다면 롤백
                if (!check(n)) {
                    if (type == 0) g[x][y] = true;
                    if (type == 1) b[x][y] = true;
                }
            }
            
        }
        result(n);
        return answer;
    }
}