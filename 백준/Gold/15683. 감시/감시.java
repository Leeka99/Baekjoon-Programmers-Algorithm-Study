import java.io.*;
import java.util.*;

class Cctv {
    int x, y, number;
    Cctv(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map;

    // map에 존재하는 cctvList 담기
    static ArrayList<Cctv> cctvList = new ArrayList<>();
    
    // 북을 기준으로 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    // cctv 방향별 감시지역. 1~5
    static int[][][] directions = {
        {{0},{1},{2},{3}},
        {{0,2},{1,3}},
        {{0,1},{1,2},{2,3},{3,0}},
        {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
        {{0,1,2,3}}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5) cctvList.add(new Cctv(i, j, map[i][j]));
            }
        }
        
        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs(int idx, int[][] tempMap){
        
        // map의 모든 cctv 확인했다면 사각지대 확인
        if(idx == cctvList.size()){
            answer = Math.min(answer, countBlindSpot(tempMap));
            return;
        }
        
        Cctv cctv = cctvList.get(idx);
        int x = cctv.x;
        int y = cctv.y;
        int num = cctv.number-1;
        
        // 해당 cctv번호에서 가능한 방향 모두 탐색
        for(int i = 0; i < directions[num].length; i++){
            int[][] copyMap = copyMap(tempMap);
            for(int dir : directions[num][i]){
                watch(copyMap, x, y, dir);
            }
            dfs(idx + 1, copyMap);
        }
    }
    
    // 해당 방향의 cctv 모두 확인
    static void watch(int[][] tempMap, int x, int y, int dir){
        int nx = x;
        int ny = y;
        while(true){
            nx += dx[dir];
            ny += dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || tempMap[nx][ny] == 6) break;
            if(tempMap[nx][ny] == 0) tempMap[nx][ny] = 7; // 감시 영역 표시
        }
    }
    
    // 사각지대 계산
    static int countBlindSpot(int[][] tempMap){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tempMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    
    // map 복사
    static int[][] copyMap(int[][] arr){
        int[][] copy = new int[n][m];
        for(int i = 0; i < n; i++){
            copy[i] = arr[i].clone();
        }
        return copy;
    }
}
