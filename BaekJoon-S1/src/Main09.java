
//No.2468(안전 영역) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main09 {
	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		int ans = 0;

		while (max >= 0) {
			int cnt = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > max && !visited[i][j]) {
						bfs(i, j, max);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
			max--;
		}

		System.out.println(ans);
	}

	public static void bfs(int x, int y, int depth) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		visited[x][y] = true;

		int tmpx, tmpy;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				tmpx = tmp.x + dx[i];
				tmpy = tmp.y + dy[i];

				if (!range(tmpx, tmpy)) {
					continue;
				}

				if (visited[tmpx][tmpy]) {
					continue;
				}

				if (arr[tmpx][tmpy] > depth) {
					visited[tmpx][tmpy] = true;
					queue.offer(new Node(tmpx, tmpy));
				}
			}
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}