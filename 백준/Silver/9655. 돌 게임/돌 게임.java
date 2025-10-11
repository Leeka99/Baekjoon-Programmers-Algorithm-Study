import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int number = n % 2;

        if (number == 0) System.out.println("CY");
        if (number != 0) System.out.println("SK");
    }
}
