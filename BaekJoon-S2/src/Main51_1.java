
//No.5567(결혼식) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main51_1 {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		graph = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		visit = new boolean[n + 1];

		System.out.println(bfs(1));
	}

	public static int bfs(int start) {
		int cnt = 0;
		int idx = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start] = true;

		while (!queue.isEmpty() && idx<3) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int tmp = queue.poll();

				for (int val : graph.get(tmp)) {
					if (!visit[val]) {
						visit[val] = true;
						queue.offer(val);
						cnt++;
					}
				}
			}
			idx++;
		}
		return cnt;
	}
}