
//No.1564(팩토리얼5) - 정수론
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main67 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		long num = 1;
		long k = (long) 1e12;

		for (int i = 1; i <= N; i++) {
			num *= i;

			while (num % 10 == 0) {
				num /= 10;
			}

			num %= k;
		}

		num %= 100000;
		int idx = 4;

		while (num < Math.pow(10, idx)) {
			sb.append(0);
			idx--;
		}
		sb.append(num);

		System.out.println(sb);
	}
}