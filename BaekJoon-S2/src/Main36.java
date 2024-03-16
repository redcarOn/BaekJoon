
//No.15663
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main36 {
	public static int N, M;
	public static int[] arr;
	public static int[] ans;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[M];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		DFS(0);

		System.out.println(sb);
	}

	public static void DFS(int depth) {
		if (depth == M) {
			for (int val : ans) {
				sb.append(val + " ");
			}
			sb.append('\n');
			return;
		}
		int before = 0;

		for (int i = 0; i < N; i++) {
			if (!visit[i] && before != arr[i]) {
				visit[i] = true;
				ans[depth] = arr[i];
				before = arr[i];
				DFS(depth + 1);
				visit[i] = false;
			}
		}
	}
}