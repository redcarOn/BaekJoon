
//No.18353(병사 배치하기) - Top-Down
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main65_1 {
	public static int[] arr;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, LIS(i));
		}

		System.out.println(N - max);
	}

	public static int LIS(int n) {
		if (dp[n] == 0) {
			dp[n] = 1;

			for (int i = n - 1; i >= 0; i--) {
				if (arr[n] < arr[i]) {
					dp[n] = Math.max(dp[n], LIS(i) + 1);
				}
			}
		}
		return dp[n];
	}
}