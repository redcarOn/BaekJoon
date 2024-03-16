
//No.1914(하노이 탑) - 재귀★ + 큰정수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main35 {
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		BigInteger big = new BigInteger("2");

		sb.append(big.pow(N).subtract(new BigInteger("1"))).append('\n');

		if (N <= 20) {
			hanoi(N, 1, 2, 3);
		}
		System.out.println(sb);
	}

	public static void hanoi(int n, int start, int mid, int end) {
		if (n == 0) {
			return;
		}

		hanoi(n - 1, start, end, mid);
		sb.append(start).append(" ").append(end).append('\n');
		hanoi(n - 1, mid, start, end);
	}
}