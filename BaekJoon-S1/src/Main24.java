
//No.5014(스타트링크) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main24 {
	public static int F;
	public static int min = 0;
	public static int[] isvisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		isvisited = new int[F + 1];

		if (bfs(S, G, U, D)) {
			sb.append(min);
		} else {
			sb.append("use the stairs");
		}

		System.out.println(sb);

	}

	public static boolean bfs(int S, int G, int U, int D) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(S);
		isvisited[S] = 1;

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			if (tmp == G) {
				min = isvisited[tmp] - 1;
				return true;
			}

			if (isRange(tmp + U)) {
				if (isvisited[tmp + U] == 0) {
					isvisited[tmp + U] = isvisited[tmp] + 1;
					queue.add(tmp + U);
				}
			}

			if (isRange(tmp - D)) {
				if (isvisited[tmp - D] == 0) {
					isvisited[tmp - D] = isvisited[tmp] + 1;
					queue.add(tmp - D);
				}
			}
		}
		return false;
	}

	public static boolean isRange(int n) {
		return 0 < n && n <= F;
	}
}