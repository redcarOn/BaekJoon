//No.2439
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = N; j > 0; j--) {
				if (j <= i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
