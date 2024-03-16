
//No.10974
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main33 {
	public static StringBuilder sb;
	public static int N;
	public static int[] arr;
	public static boolean[] isvisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isvisited = new boolean[N + 1];

		dfs(0);

		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == N) {
			for (int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!isvisited[i]) {
				isvisited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				isvisited[i] = false;
			}
		}
	}
}