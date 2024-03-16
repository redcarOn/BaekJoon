
//No.1926(그림) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main30_1 {
	public static int n, m, check;
	public static int[][] arr;
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					count++;
					check = 0;
					dfs(i, j);
					max = Math.max(max, check);
				}
			}
		}

		sb.append(count).append('\n').append(max);
		System.out.println(sb);
	}

	public static void dfs(int y, int x) {
		arr[y][x] = 0;
		check++;

		for (int i = 0; i < 4; i++) {
			int tmpy = y + dy[i];
			int tmpx = x + dx[i];

			if (!range(tmpy, tmpx) || arr[tmpy][tmpx] == 0) {
				continue;
			}
			dfs(tmpy, tmpx);
		}
	}

	public static boolean range(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
}