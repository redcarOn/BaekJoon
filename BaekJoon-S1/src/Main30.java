
//No.1926(그림) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main30 {
	public static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static int n, m;
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
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		sb.append(count).append('\n').append(max);
		System.out.println(sb);
	}

	public static int bfs(int y, int x) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(y, x));
		arr[y][x] = 0;
		int num = 0;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			num++;

			for (int i = 0; i < 4; i++) {
				int tmpy = tmp.y + dy[i];
				int tmpx = tmp.x + dx[i];

				if (!range(tmpy, tmpx) || arr[tmpy][tmpx] == 0) {
					continue;
				}

				queue.offer(new Node(tmpy, tmpx));
				arr[tmpy][tmpx] = 0;
			}
		}
		return num;
	}

	public static boolean range(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
}