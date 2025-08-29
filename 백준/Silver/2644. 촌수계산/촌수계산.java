import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static boolean[] visited;
    public static int[] distance;
    public static int n; // 전체 사람 수
    public static int m; // 부모자식 관계 수
    
    public static int p1;
    public static int p2;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        System.out.println(bfs(p1));
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (arr[curr][i] == 1 && !visited[i]) {
                    distance[i] = distance[curr] + 1;
                    visited[i] = true;
                    queue.add(i);
                    if (i == p2) return distance[i];
                }
                
            }
        }
        return -1;
    }
}
