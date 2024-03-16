
//No.11055 + Top-Down
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main26_1 {
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

		dp[0] = arr[0];
		LIS(N - 1);

		int max = Integer.MIN_VALUE;
		for (int cost : dp) {
			max = Math.max(max, cost);
		}

		System.out.println(max);
	}

	public static int LIS(int N) {
		if (dp[N] == null) {
			dp[N] = arr[N];

			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + arr[N]);
				} else {
					LIS(i);
				}
			}
		}
		return dp[N];
	}
}