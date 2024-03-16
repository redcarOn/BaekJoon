
//No.6064(카잉 달력) - 브루트포스★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int M, N, x, y;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			sb.append(cal(M, N, x - 1, y - 1)).append('\n'); // mod연산 이용하기위해서 -1
		}

		System.out.println(sb);
	}

	public static int cal(int M, int N, int x, int y) {
		int maxYear = M * N / gcd(M, N);
		int year = x;

		while (year <= maxYear) {
			if (year % N == y) {
				return year + 1;
			}
			year += M;
		}

		return -1;
	}

	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}