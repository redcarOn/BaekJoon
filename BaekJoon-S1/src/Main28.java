
//No.11403(경로 찾기) - 최단경로(BFS-리스트) 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main28 {
	public static int N;
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] isvisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (num == 0) {
					continue;
				}
				graph.get(i).add(j);
			}
		}

		for (int i = 1; i <= N; i++) {
			isvisited = new boolean[N + 1];
			bfs(i);

			for (int j = 1; j <= N; j++) {
				if (isvisited[j]) {
					sb.append(1).append(' ');
				} else {
					sb.append(0).append(' ');
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			for (int node : graph.get(tmp)) {
				if (!isvisited[node]) {
					queue.offer(node);
					isvisited[node] = true;
				}
			}
		}
	}
}