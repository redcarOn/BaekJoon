
//No.1182
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14 {
	public static int[] arr;
	public static int N, S, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		count = 0;
		dfs(0, 0);

		if (S == 0) {
			count -= 1;
		}
		System.out.println(count);
	}

	public static void dfs(int start, int sum) {
		if (start == N) {
			if (sum == S) {
				count++;
			}
			return;
		}
		dfs(start + 1, sum + arr[start]);
		dfs(start + 1, sum);
	}
}