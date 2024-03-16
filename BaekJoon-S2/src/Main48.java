
//No,11060 - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main48 {
	public static final int MAX = 1001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, MAX);
		dp[1] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= i + arr[i]; j++) {
				if (j <= N) {
					dp[j] = Math.min(dp[j], dp[i] + 1);
				}
			}
		}

		System.out.println(dp[N] == MAX ? -1 : dp[N]);
	}
}