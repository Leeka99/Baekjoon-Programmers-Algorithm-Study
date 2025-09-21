import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] map;
    public static int[][][] mino = {

    // ㅡ 모양
    {{0,0},{0,1},{0,2},{0,3}}, {{0,0},{1,0},{2,0},{3,0}},
    
    // ㅁ 모양
    {{0,0},{0,1},{1,0},{1,1}},
    
    // L, J 모양
    {{0,0},{1,0},{2,0},{2,1}}, {{0,0},{0,1},{0,2},{1,0}},
    {{0,0},{0,1},{1,1},{2,1}}, {{0,2},{1,0},{1,1},{1,2}},
    {{0,0},{1,0},{1,1},{1,2}}, {{0,1},{1,1},{2,0},{2,1}},
    {{0,0},{0,1},{0,2},{1,2}}, {{0,0},{1,0},{2,0},{0,1}},
    
    // Z, S 모양
    {{0,0},{1,0},{1,1},{2,1}}, {{0,1},{1,0},{1,1},{2,0}},
    {{0,0},{0,1},{1,1},{1,2}}, {{1,0},{1,1},{0,1},{0,2}},
    
    // T 모양
    {{0,0},{0,1},{0,2},{1,1}}, {{0,0},{1,0},{2,0},{1,1}},
    {{0,1},{1,0},{1,1},{1,2}}, {{1,0},{0,1},{1,1},{2,1}}
    };

    public static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[][] shape : mino) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    int sum = 0;
                    boolean ok = true;
                    for(int[] block : shape){
                        int nx = x + block[0];
                        int ny = y + block[1];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                            ok = false;
                            break;
                        }
                        sum += map[nx][ny];
                    }
                    if(ok) answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }
}