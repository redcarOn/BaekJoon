//No.11720
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N, sum;
		N = sc.nextInt();
		String str = sc.next();
		sum = 0;
		for (int i = 0; i < N; i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
		sc.close();
	}
}
