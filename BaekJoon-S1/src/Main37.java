
//No.12852(1로 만들기 2) - DP(배열)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main37 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] arr = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			arr[i] = i - 1;

			if (i % 2 == 0) {
				if (dp[i] > dp[i / 2] + 1) {
					dp[i] = dp[i / 2] + 1;
					arr[i] = i / 2;
				}
			}

			if (i % 3 == 0) {
				if (dp[i] > dp[i / 3] + 1) {
					dp[i] = dp[i / 3] + 1;
					arr[i] = i / 3;
				}
			}
		}

		sb.append(dp[N]).append('\n');
		sb.append(N + " ");

		while (N > 1) {
			N = arr[N];
			sb.append(N + " ");
		}

		System.out.println(sb);
	}
}