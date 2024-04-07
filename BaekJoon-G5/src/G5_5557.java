
// No.5557(1학년) - 49
// DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_5557 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long[][] dp = new long[N - 1][21];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][arr[0]] = 1;

		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] > 0) {
					int plusSum = j + arr[i];
					int minusSum = j - arr[i];

					if (plusSum >= 0 && plusSum <= 20) {
						dp[i][plusSum] += dp[i - 1][j];
					}

					if (minusSum >= 0 && minusSum <= 20) {
						dp[i][minusSum] += dp[i - 1][j];
					}
				}
			}
		}

		System.out.println(dp[N - 2][arr[N - 1]]);
	}
}