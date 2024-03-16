
//No.2178(미로 탐색)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main03 {

	public static class Node {
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static int N, M;
	public static int[][] arr;
	public static int[][] check;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		check = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = s.charAt(j - 1) - '0';
				check[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs();

		System.out.println(check[N][M]);
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, 1, 1));
		check[1][1] = 1;
		int tmpx, tmpy, tmpc;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				tmpx = tmp.x + dx[i];
				tmpy = tmp.y + dy[i];
				tmpc = tmp.cnt + 1;
				if (!range(tmpx, tmpy)) {
					continue;
				}

				if (check[tmpx][tmpy] != Integer.MAX_VALUE || arr[tmpx][tmpy] == 0) {
					continue;
				}

				check[tmpx][tmpy] = tmpc;
				queue.offer(new Node(tmpx, tmpy, tmpc));

			}
		}
	}

	public static boolean range(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= M;
	}
}