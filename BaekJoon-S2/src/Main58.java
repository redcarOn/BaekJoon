
//No.24444(알고리즘 수업 - 너비 우선 탐색 1)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main58 {
	public static int N, M, R;
	public static ArrayList<ArrayList<Integer>> graph;
	public static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		graph = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		bfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int idx = 1;
		queue.offer(start);
		visited[start] = idx++;

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			for (int val : graph.get(tmp)) {
				if (visited[val] == 0) {
					visited[val] = idx++;
					queue.offer(val);
				}
			}
		}
	}
}