
//No.14889(스타트와 링크) - 백트래킹(N/2분배)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11_2 {
	public static int N;
	public static int[][] arr;
	public static boolean[] visited;
	public static int[] startT, linkT;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		startT = new int[N / 2];
		linkT = new int[N / 2];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		startT[0] = 0;
		dfs(1, 1);

		System.out.println(min);
	}

	public static void dfs(int start, int depth) {
		if (depth == N / 2) {
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					linkT[idx++] = i;
				}
			}
			func();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				startT[depth] = i;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void func() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i != j) {
					start += arr[startT[i]][startT[j]];
					link += arr[linkT[i]][linkT[j]];
				}
			}
		}

		int val = Math.abs(start - link);

		if (val == 0) {
			System.out.println(0);
			System.exit(0);
		}

		min = Math.min(min, val);
	}
}