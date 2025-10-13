import java.io.*;
import java.util.*;

public class Main {
    static int p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        p = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            List<Integer> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int j = 0; j < 20; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (arr.isEmpty()) {
                    arr.add(number);
                    continue;
                }

                boolean insert = false;
                for (int k = 0; k < arr.size(); k++) {
                    if (arr.get(k) > number){
                        arr.add(k, number);
                        insert = true;
                        cnt += arr.size() - 1 - k;
                        break;
                    }
                }

                if (!insert) arr.add(number);
            }
            System.out.println(index + " " + cnt);
            
        }
    }
}
