
//No.10971
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24 {
	public static int[][] arr;
	public static boolean[] visit;
	public static int N, cost;
	public static int min = Integer.MAX_VALUE;
	public static int[] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		tmp = new int[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0);
		System.out.println(min);
	}

	public static void DFS(int depth) {
		if (depth == N) {
			cost = 0;
			for (int i = 0; i < N; i++) {
				int num = arr[tmp[i % N]][tmp[(i + 1) % N]];

				if (num == 0) {
					return;
				} else {
					cost += num;
				}

			}
			min = Math.min(min, cost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				tmp[depth] = i;
				DFS(depth + 1);
				visit[i] = false;
			}
		}
	}
}