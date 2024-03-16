
//No.2294(동전 2) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main16 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		int[] dp = new int[K + 1];

		Arrays.fill(dp, 100001);

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}

		if (dp[K] == 100001) {
			dp[K] = -1;
		}

		System.out.println(dp[K]);
	}
}