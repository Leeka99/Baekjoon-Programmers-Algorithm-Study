import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) System.out.println("CY");
        if (n % 2 != 0) System.out.println("SK");
    }
}
