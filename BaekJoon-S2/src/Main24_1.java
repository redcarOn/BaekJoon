
//No.10971 - first에서만 출발해도 결과는 같음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24_1 {
	public static int[][] arr;
	public static boolean[] visit;
	public static int N, cost;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 0, 0);
		System.out.println(min);
	}

	public static void DFS(int start, int sum, int depth) {
		if (depth == N - 1) {
			if (arr[start][0] != 0) {
				min = Math.min(min, sum + arr[start][0]);
			}
			return;
		}

		for (int i = 1; i < N; i++) {
			if (!visit[i] && arr[start][i] > 0) {
				visit[i] = true;
				DFS(i, sum + arr[start][i], depth + 1);
				visit[i] = false;
			}
		}
	}
}