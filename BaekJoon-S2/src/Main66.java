
//No.1058(친구)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main66 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visited;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();

			for (int j = 1; j <= N; j++) {
				char c = s.charAt(j - 1);

				if (c == 'N') {
					continue;
				}
				graph.get(i).add(j);
			}
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];

			max = Math.max(max, bfs(i));
		}

		System.out.println(max);

	}

	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		int cnt = 0;
		int idx = 0;

		while (!queue.isEmpty() && idx < 2) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();

				for (int node : graph.get(tmp)) {
					if (!visited[node]) {
						visited[node] = true;
						queue.offer(node);
						cnt++;
					}
				}
			}
			idx++;
		}

		return cnt;
	}
}