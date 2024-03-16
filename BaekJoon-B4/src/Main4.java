//No.2530
import java.io.IOException;
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int A, B, C, D;
		int a, b, c;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();

		c = D % 60;
		b = D / 60;
		a = 0;
		if (b >= 60) {
			a = b / 60;
			b %= 60;
		}
		A += a;
		B += b;
		C += c;
		if (C >= 60) {
			B += C / 60;
			C %= 60;
		}
		if (B >= 60) {
			A += B / 60;
			B %= 60;
		}
		if (A >= 24)
			A %= 24;
		System.out.println(A + " " + B + " " + C);
		sc.close();
	}
}