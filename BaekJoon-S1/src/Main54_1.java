
//No.1052(물병) -  그리디알고리즘★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main54_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(func(N, K));
	}

	public static int func(int N, int K) {
		if (N <= K) {
			return 0;
		}

		for (int i = 0; i < K - 1; i++) {
			int num = 0;

			while (Math.pow(2, num) < N) {
				num++;
			}
			N -= Math.pow(2, num - 1);

			if (N == 0) {
				return 0;
			}
		}

		int num = 0;

		while (Math.pow(2, num) < N) {
			num++;
		}

		return (int) Math.pow(2, num) - N;
	}
}