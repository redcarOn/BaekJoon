
//No.18352 - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main29 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static int[] arr;
	public static int N, M, K, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		arr = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			arr[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}

		BFS();

		for (int i = 1; i <= N; i++) {
			if (arr[i] == K) {
				sb.append(i).append('\n');
			}
		}

		if (sb.length() == 0) {
			sb.append(-1);
		}

		System.out.println(sb);
	}

	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		arr[X] = 0;
		queue.offer(X);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			for (int node : graph.get(tmp)) {
				if (arr[node] == -1) {
					arr[node] = arr[tmp] + 1;
					queue.offer(node);
				}
			}
		}
	}
}