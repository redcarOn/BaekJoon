
//No.2606 - 인접리스트 + BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main07_3 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static Queue<Integer> queue;
	public static boolean[] visit;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int C = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		visit = new boolean[C + 1];

		for (int i = 0; i <= C; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		BFS(1, C);
		System.out.println(count);
	}

	public static void BFS(int num, int C) {
		queue = new LinkedList<Integer>();

		visit[num] = true;
		queue.offer(num);

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int node : graph.get(temp)) {
				if (!visit[node]) {
					queue.offer(node);
					visit[node] = true;
					count++;
				}
			}
		}
	}
}