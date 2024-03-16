
//No.1325(효율적인 해킹) - BFS(시간단축!!)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(B).add(A);
		}

		int[] cnt = new int[N + 1];
		int max = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			queue.offer(i);

			while (!queue.isEmpty()) {
				int now = queue.poll();
				if (visited[i][now]) {
					continue;
				}
				visited[i][now] = true;
				cnt[i]++;

				int size = graph.get(now).size();

				for (int j = 0; j < size; j++) {
					if (visited[i][graph.get(now).get(j)]) {
						continue;
					}

					if (graph.get(now).get(j) < i) {
						for (int k = 1; k <= N; k++) {
							if (visited[i][k]) {
								continue;
							}
							if (visited[graph.get(now).get(j)][k]) {
								visited[i][k] = true;
								cnt[i]++;
							}
						}
					} else {
						queue.offer(graph.get(now).get(j));
					}
				}
			}
			max = Math.max(cnt[i], max);
		}

		for (int i = 1; i <= N; i++) {
			if (max == cnt[i]) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}
}