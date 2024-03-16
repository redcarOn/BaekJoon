
//No.1303(전쟁 - 전투) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main52 {
	public static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static int N, M;
	public static char[][] arr;
	public static boolean[][] isvisited;
	public static int[] dy = { 0, 0, 1, -1 };
	public static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		isvisited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		int white = 0;
		int blue = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!isvisited[i][j]) {
					if (arr[i][j] == 'W') {
						white += Math.pow(bfs(i, j, arr[i][j]), 2);
					} else {
						blue += Math.pow(bfs(i, j, arr[i][j]), 2);
					}
				}
			}
		}

		sb.append(white).append(" ").append(blue);
		System.out.println(sb);
	}

	public static int bfs(int y, int x, char c) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(y, x));
		isvisited[y][x] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int tmpy = tmp.y + dy[i];
				int tmpx = tmp.x + dx[i];

				if (isRange(tmpy, tmpx) && !isvisited[tmpy][tmpx] && arr[tmpy][tmpx] == c) {
					queue.offer(new Node(tmpy, tmpx));
					isvisited[tmpy][tmpx] = true;
				}
			}
		}
		return cnt;
	}

	public static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < M && x < N;
	}
}