
//No.9205(맥주 마시면서 걸아가기★)  -  BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main35 {
	private static class Point {
		int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Point> pos = new ArrayList<>();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			for (int j = 0; j < N + 2; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				pos.add(new Point(x, y));
			}

			for (int j = 0; j < N + 2; j++) {
				graph.add(new ArrayList<>());
			}

			for (int j = 0; j < N + 2; j++) {
				for (int k = j + 1; k < N + 2; k++) {
					if (dis(pos.get(j), pos.get(k)) <= 1000) {
						graph.get(j).add(k);
						graph.get(k).add(j);
					}
				}
			}

			sb.append(BFS(graph, N) ? "happy" : "sad").append('\n');
		}
		System.out.println(sb);
	}

	public static int dis(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 2];
		queue.offer(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == N + 1) {
				return true;
			}

			for (int next : graph.get(now)) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}

		return false;
	}
}
