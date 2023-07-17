import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int N = sc.nextInt();
		int a;
		int b;
		int result = 0;
		
		for(int i=0; i<N; i++) {
		 a = sc.nextInt();
		 b = sc.nextInt();
		 result += a*b; 
			
		}
		if(result==X) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		

	}

}