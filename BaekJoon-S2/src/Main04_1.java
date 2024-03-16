
//No.1012 - DFS 스택
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main04_1 {
	public static int[][] graph;
	public static boolean[][] isvisited;
	public static int M, N, K, count;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static Stack<Node> stack = new Stack<>();

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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			graph = new int[N][M];
			isvisited = new boolean[N][M];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			count = 0;

			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (!isvisited[x][y] && graph[x][y] == 1) {
						count++;
						dfs(x, y);
					}
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		stack.add(new Node(x, y));
		isvisited[x][y] = true;

		while (!stack.isEmpty()) {
			Node node = stack.pop();

			for (int i = 0; i < 4; i++) {
				int newX = node.x + dx[i];
				int newY = node.y + dy[i];

				if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
					if (!isvisited[newX][newY] && graph[newX][newY] == 1) {
						stack.push(new Node(newX, newY));
						isvisited[newX][newY] = true;
					}
				}
			}
		}
	}
}