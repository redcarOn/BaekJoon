
//No.11053 - Top-Down
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main05_1 {
	public static int[] arr;
	public static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new Integer[N];

		for (int i = 0; i < N; i++) {
			LIS(i);
		}

		int max = dp[0];

		for (int i = 1; i < N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

	public static int LIS(int N) {
		if (dp[N] == null) {
			dp[N] = 1;

			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
}