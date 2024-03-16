
//No.18353(병사 배치하기) - Bottom-Up
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main65 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(dp[i], max);
		}

		System.out.println(N - max);
	}
}