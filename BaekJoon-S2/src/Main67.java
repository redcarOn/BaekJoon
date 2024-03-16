
//No.17086(아기 상어 2) - 전체
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main67 {
	public static class Node {
		int x;
		int y;
		int d;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static int N, M;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 1) {
					int num = bfs(i, j, 0);
					max = Math.max(max, num);
				}
			}
		}

		System.out.println(max);
	}

	public static int bfs(int x, int y, int d) {
		Queue<Node> queue = new LinkedList<>();
		visited = new boolean[N][M];
		queue.offer(new Node(x, y, d));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 8; i++) {
				int tmpx = node.x + dx[i];
				int tmpy = node.y + dy[i];
				int tmpd = node.d + 1;

				if (!range(tmpx, tmpy) || visited[tmpx][tmpy]) {
					continue;
				}

				if (arr[tmpx][tmpy] == 1) {
					return tmpd;
				}

				queue.offer(new Node(tmpx, tmpy, tmpd));
				visited[tmpx][tmpy] = true;
			}
		}
		return 0;
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}
