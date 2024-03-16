
//No.1389(케빈 베이컨의 6단계 법칙) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main31 {
	public static int N, M;
	public static ArrayList<ArrayList<Integer>> graph;
	public static int[] arr;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		arr = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph.get(s).add(e);
			graph.get(e).add(s);
		}

		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			bfs(i);

			if (min > arr[i]) {
				min = arr[i];
				idx = i;
			}
		}

		System.out.println(idx);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;
		int num = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();

				for (int node : graph.get(tmp)) {
					if (!visited[node]) {
						queue.offer(node);
						visited[node] = true;
						arr[start] += num;
					}
				}
			}
			num++;
		}
	}
}