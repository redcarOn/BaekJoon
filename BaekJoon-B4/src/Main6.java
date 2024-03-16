//No.1526
import java.io.IOException;
import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Double A, B, C;
		A = sc.nextDouble();
		B = sc.nextDouble();
		C = sc.nextDouble();
		int result=((A/B*C)>(A*B/C)?(int)(A/B*C):(int)(A*B/C));
		System.out.println(result);
		sc.close();
	}
}
