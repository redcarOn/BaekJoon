
//No.15655
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main44 {
	public static int N, M;
	public static int[] arr;
	public static int[] seq;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		seq = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0);

		System.out.println(sb);
	}

	public static void dfs(int start, int depth) {
		if (depth == M) {
			for (int val : seq) {
				sb.append(val + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i < N; i++) {
			seq[depth] = arr[i];
			dfs(i + 1, depth + 1);
		}
	}
}