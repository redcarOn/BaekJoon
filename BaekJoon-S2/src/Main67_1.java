
//No.17086(아기 상어 2) - 상어부터★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main67_1 {
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
	public static Queue<Node> queue;
	public static int max;
	public static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1) {
					queue.offer(new Node(i, j, 0));
				}
			}
		}

		bfs();

		System.out.println(max);
	}

	public static void bfs() {

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 8; i++) {
				int tmpx = node.x + dx[i];
				int tmpy = node.y + dy[i];
				int tmpd = node.d + 1;

				if (range(tmpx, tmpy)) {
					if (arr[tmpx][tmpy] == 0 || (arr[tmpx][tmpy] != 0 && arr[tmpx][tmpy] > tmpd)) {
						arr[tmpx][tmpy] = tmpd;
						queue.offer(new Node(tmpx, tmpy, tmpd));
						max = Math.max(max, tmpd);
					}
				}
			}
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}