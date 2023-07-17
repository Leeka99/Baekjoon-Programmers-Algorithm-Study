import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<(N/4); i++) {
			System.out.print("long ");
		}
		sc.close();
		System.out.println("int");
	}

}