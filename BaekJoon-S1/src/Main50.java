
//No.2302(극장 좌석) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main50 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int ans = 1;
		int before = 0;

		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(br.readLine());
			ans *= dp[idx - before - 1];
			before = idx;
		}
		ans *= dp[N - before];

		System.out.println(ans);
	}
}