
//No.1110
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int a, b, temp;
		if (N < 10) {
			a = 0;
			b = N;
		} else {
			a = N / 10;
			b = N % 10;
		}
		while (true) {
			temp = a;
			a = b;
			b = (temp + a) % 10;
			count++;
			if (a * 10 + b == N) {
				break;
			}
		}
		System.out.println(count);
	}
}