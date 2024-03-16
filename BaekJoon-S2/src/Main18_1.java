
//No.4963 - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18_1 {
	public static int[][] arr;
	public static boolean[][] isvisited;
	public static int w, h;
	public static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str;

		while (!(str = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			arr = new int[h][w];
			isvisited = new boolean[h][w];
			int count = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && !isvisited[i][j]) {
						BFS(i, j);
						count++;
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		isvisited[x][y] = true;
		queue.offer(new Node(x, y));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 8; i++) {
				int x2 = node.x + dx[i];
				int y2 = node.y + dy[i];

				if (area(x2, y2) && arr[x2][y2] == 1 && !isvisited[x2][y2]) {
					isvisited[x2][y2] = true;
					queue.offer(new Node(x2, y2));
				}
			}
		}
	}

	public static boolean area(int x, int y) {
		if (x < 0 || y < 0 || x >= h || y >= w) {
			return false;
		} else {
			return true;
		}
	}
}