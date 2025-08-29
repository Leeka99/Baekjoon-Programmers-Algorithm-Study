import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static boolean[] visited = new boolean[100001];
    public static int[] answer = new int[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queue.add(n);
        visited[n] = true;
        bfs();
        System.out.println(answer[k]);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            int curr = queue.poll();

            int nextM = curr - 1;
            int nextP = curr + 1;
            int nextT = curr * 2;

            if (nextM >= 0 && !visited[nextM]) {
                queue.add(nextM);
                visited[nextM] = true;
                answer[nextM] = answer[curr] + 1;
            }
            if (nextP <= 100000 && !visited[nextP]) {
                queue.add(nextP);
                visited[nextP] = true;
                answer[nextP] = answer[curr] + 1;
            }
            if (nextT <= 100000 && !visited[nextT]) {
                queue.add(nextT);
                visited[nextT] = true;
                answer[nextT] = answer[curr] + 1;
            }
        }
    }
}
