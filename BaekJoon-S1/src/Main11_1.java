
//No.14889(스타트와 링크) - 백트래킹(1만탐색 간편화)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11_1 {
	public static int N;
	public static int[][] arr;
	public static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		dfs(1, 1);

		System.out.println(min);
	}

	public static void dfs(int start, int depth) {
		if (depth == N / 2) {
			func();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void func() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] == visited[j]) {
					if (visited[i]) {
						start += arr[i][j] + arr[j][i];
					} else {
						link += arr[i][j] + arr[j][i];
					}
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