
//No.2539
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main22 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i - 1] + num;

		}

		int max = Integer.MIN_VALUE;
		for (int i = K; i <= N; i++) {
			max = Math.max(max, arr[i] - arr[i - K]);
		}
		System.out.println(max);
	}
}