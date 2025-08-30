import java.util.*;
import java.io.*;

public class Main {
    public static int f, s, g, u, d;
    public static boolean[] visited;
    public static Queue<Integer> queue = new LinkedList<>();
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];
        answer = new int[f + 1];

        queue.add(s);
        visited[s] = true;

        bfs(s);

        if (answer[g] == 0 && !visited[g]) System.out.println("use the stairs");
        else System.out.println(answer[g]);
    }

    public static void bfs(int start) {
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            int nextU = curr + u;
            int nextD = curr - d;

            if (nextU <= f && !visited[nextU]) {
                visited[nextU] = true;
                answer[nextU] = answer[curr] + 1;
                queue.add(nextU);
                
            }
            if (nextD >= 1 && !visited[nextD]) {
                visited[nextD] = true;
                answer[nextD] = answer[curr] + 1;
                queue.add(nextD);
                
            }
        }
    }
}
