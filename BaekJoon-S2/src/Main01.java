
//No.1260
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01 {
	public static int N, M, V;
	public static int dfsIdx = 0;
	public static int bfsIdx = 0;
	public static ArrayList<ArrayList<Integer>> graph;
	public static Queue<Integer> queue;
	public static boolean[] isvisitDFS;
	public static boolean[] isvisitBFS;
	public static int[] dfsArr;
	public static int[] bfsArr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		isvisitDFS = new boolean[N + 1];
		isvisitBFS = new boolean[N + 1];
		dfsArr = new int[N];
		bfsArr = new int[N];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		for (int i = 0; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		DFS(V);
		print(dfsArr);
		BFS(V);
		print(bfsArr);

		System.out.println(sb);
	}

	public static void DFS(int V) {
		isvisitDFS[V] = true;
		dfsArr[dfsIdx++] = V;
		for (int node : graph.get(V)) {
			if (isvisitDFS[node]) {
				continue;
			}
			DFS(node);
		}
	}

	public static void BFS(int V) {
		queue = new LinkedList<Integer>();
		isvisitBFS[V] = true;
		queue.offer(V);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			bfsArr[bfsIdx++] = tmp;

			for (int node : graph.get(tmp)) {
				if (!isvisitBFS[node]) {
					queue.offer(node);
					isvisitBFS[node] = true;
				}
			}
		}
	}

	public static void print(int[] arr) {
		for (int val : arr) {
			if (val != 0) {
				sb.append(val + " ");
			}
		}
		sb.append('\n');
	}
}