
//No.2583(영역 구하기) - DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main29_1 {

	public static int M, N, K, count;
	public static boolean[][] arr;
	public static ArrayList<Integer> area;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					arr[j][k] = true;
				}
			}
		}

		area = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!arr[i][j]) {
					count = 0;
					dfs(i, j);
					area.add(count);
				}
			}
		}

		Collections.sort(area);

		sb.append(area.size()).append('\n');
		for (int i : area) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}

	public static void dfs(int y, int x) {
		arr[y][x] = true;
		count++;

		for (int i = 0; i < 4; i++) {
			int tmpy = y + dy[i];
			int tmpx = x + dx[i];

			if (!range(tmpy, tmpx) || arr[tmpy][tmpx]) {
				continue;
			}

			dfs(tmpy, tmpx);
		}
	}

	public static boolean range(int y, int x) {
		return y >= 0 && x >= 0 && y < M && x < N;
	}
}