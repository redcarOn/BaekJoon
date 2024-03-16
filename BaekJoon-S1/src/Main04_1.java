
//No.2667(단지번호붙이기) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main04_1 {
	public static int N;
	public static int[][] arr;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static boolean[][] visited;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					list.add(dfs(i, j));
				}
			}
		}
		Collections.sort(list);

		sb.append(list.size()).append('\n');
		for (int num : list) {
			sb.append(num).append('\n');
		}

		System.out.println(sb);
	}

	public static int dfs(int x, int y) {
		visited[x][y] = true;
		int cnt = 1;

		for (int i = 0; i < 4; i++) {
			int tmpx = x + dx[i];
			int tmpy = y + dy[i];

			if (!range(tmpx, tmpy)) {
				continue;
			}

			if (!visited[tmpx][tmpy] && arr[tmpx][tmpy] == 1) {
				cnt += dfs(tmpx, tmpy);
			}
		}
		return cnt;
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}