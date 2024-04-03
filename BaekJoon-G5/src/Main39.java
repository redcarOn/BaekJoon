
//No.18405(경쟁적 전염) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main39 {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int type;
		int time;

		Node(int x, int y, int type, int time) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.time = time;
		}

		@Override
		public int compareTo(Node n) {
			if (this.time == n.time) {
				return this.type - n.type;
			} else {
				return this.time - n.time;
			}
		}
	}

	static int N, K, S, X, Y;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Node> pq;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					visited[i][j] = true;
					pq.offer(new Node(i, j, map[i][j], 0));
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		System.out.println(BFS());
	}

	public static int BFS() {
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.time >= S || map[X][Y] != 0) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (!isRange(nx, ny) || visited[nx][ny]) {
					continue;
				}
				visited[nx][ny] = true;
				map[nx][ny] = now.type;
				pq.offer(new Node(nx, ny, now.type, now.time + 1));
			}
		}
		return map[X][Y];
	}

	public static boolean isRange(int x, int y) {
		return x > 0 && y > 0 && x <= N && y <= N;
	}
}