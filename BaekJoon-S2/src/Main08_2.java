
//No.11724 - BFS + 인접립스트
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main08_2 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static Queue<Integer> queue;
	public static boolean[] isvisited;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		isvisited = new boolean[N + 1];
		count = 0;

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
			for (int node : graph.get(tmp)) {
				if (!isvisited[node]) {
					queue.offer(node);
					isvisited[node] = true;
				}
			}
		}
	}
}