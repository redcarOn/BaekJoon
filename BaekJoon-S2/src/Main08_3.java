
//No.11724 - DFS + 2차원배열
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main08_3 {
	public static boolean[][] graph;
	public static boolean[] isvisited;
	public static int N, count;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new boolean[N + 1][N + 1];
		isvisited = new boolean[N + 1];
		count = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
		}

		for (int i = 1; i <= N; i++) {
			if (!isvisited[i]) {
				BFS(i);
				count++;
			}
		}
		System.out.println(count);
	}

	public static void BFS(int num) {
		queue = new LinkedList<>();
		isvisited[num] = true;
		queue.offer(num);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!isvisited[i] && graph[tmp][i]) {
					queue.offer(i);
					isvisited[i] = true;
				}
			}
		}
	}
}