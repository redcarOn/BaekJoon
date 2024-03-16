
//No.15664(N과 M (10))
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main59 {
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[] arr;
	public static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

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

		int before = 0;

		for (int i = start; i < N; i++) {
			if (before != arr[i]) {
				seq[depth] = arr[i];
				before = arr[i];
				dfs(i + 1, depth + 1);
			}
		}
	}
}