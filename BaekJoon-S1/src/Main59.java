
//No.16194(카드 구매하기 2) - DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main59 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + arr[j]);
			}
		}

		System.out.println(dp[N]);
	}
}