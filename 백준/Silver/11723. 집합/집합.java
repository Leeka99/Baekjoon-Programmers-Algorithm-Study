import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static Set<Integer> all = new HashSet<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (!st.hasMoreTokens()) {
                
                if (s.equals("all")) {
                    set = new HashSet<>(all);
                }

                if (s.equals("empty")) {
                    set.clear();
                }
                
            }
            else {
                int num = Integer.parseInt(st.nextToken());
                boolean b = set.contains(num);

                if (s.equals("add") && !b) {
                    set.add(num);
                }

                if (s.equals("remove") && b) {
                    set.remove(num);
                }
                
                if (s.equals("check")) {
                    if (b) sb.append(1).append('\n');
                    if (!b) sb.append(0).append('\n');
                }

                if (s.equals("toggle")) {
                    if (b) set.remove(num);
                    if (!b) set.add(num);
                }
            }
        }

        System.out.println(sb);
    }
}
