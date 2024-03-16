
//No.11722 + Bottom-Up
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main38 {
	public static int N;
	public static int[] dp;
	public static int min = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		func(arr);

		System.out.println(min);
	}

	public static void func(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		for (int val : dp) {
			min = Math.max(val, min);
		}
	}
}