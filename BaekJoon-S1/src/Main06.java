
//No.2156(포도주 시식) - DP(Bottom-Up)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main06 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];
		dp[1] = arr[1];

		if (n > 1) {
			dp[2] = arr[2] + dp[1];
		}

		for (int i = 3; i <= n; i++) {
			int tmp = arr[i] + Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]);
			dp[i] = Math.max(dp[i - 1], tmp);
		}

		System.out.println(dp[n]);
	}
}