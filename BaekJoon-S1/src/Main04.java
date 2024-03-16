
//No.2667(단지번호붙이기) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main04 {
	public static int N;
	public static int[][] arr;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static boolean[][] visited;
	public static ArrayList<Integer> list;

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

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		Collections.sort(list);

		sb.append(count).append('\n');
		for (int num : list) {
			sb.append(num).append('\n');
		}

		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new Node(x, y));
		int cnt = 1;
		int tmpx, tmpy;

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				tmpx = tmp.x + dx[i];
				tmpy = tmp.y + dy[i];

				if (range(tmpx, tmpy)) {
					if (!visited[tmpx][tmpy] && arr[tmpx][tmpy] == 1) {
						visited[tmpx][tmpy] = true;
						queue.offer(new Node(tmpx, tmpy));
						cnt++;
					}
				}

			}
		}
		list.add(cnt);
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}