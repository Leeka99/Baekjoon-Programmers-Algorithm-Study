import java.io.*;
import java.util.*;

public class Main {
    static int h, w, n, m; // map 크기(h:세로, w:가로), 띄움 조건(n:세로, m:가로)
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i+=n+1) {
            for (int j = 0; j < w; j+=m+1) {
                answer++;
            }
        }
        System.out.println(answer);
    }    
}
