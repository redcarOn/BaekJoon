
//No.1916(최소비용 구하기) - dijkstra
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main08 {
	public static class Node implements Comparable<Node> {
		int end;
		int cnt;

		public Node(int end, int cnt) {
			this.end = end;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}

	public static int N;
	public static ArrayList<ArrayList<Node>> graph;
	public static boolean[] isvisited;
	public static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		graph = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		isvisited = new boolean[N + 1];
		check = new int[N + 1];
		Arrays.fill(check, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(s).add(new Node(e, c));
		}

		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		dijkstra(x, y);

		System.out.println(check[y]);
	}

	public static void dijkstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(x, 0));
		check[x] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int cur = now.end;

			if (!isvisited[cur]) {
				isvisited[cur] = true;

				for (Node node : graph.get(cur)) {
					if (!isvisited[node.end] && check[node.end] > check[cur] + node.cnt) {
						check[node.end] = check[cur] + node.cnt;
						pq.offer(new Node(node.end, check[node.end]));
					}
				}
			}
		}
	}
}