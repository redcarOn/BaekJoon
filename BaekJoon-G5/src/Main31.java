
//No.16928(뱀과 사다리 게임) - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main31 {
	public static int[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new int[101];

		for (int i = 1; i <= 100; i++) {
			board[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			board[u] = v;
		}

		System.out.println(bfs(1));
	}

	public static int bfs(int start) {
		int[] check = new int[101];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		check[start] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= 6; i++) {
				int tmp = now + i;

				if (tmp > 100) {
					continue;
				}

				if (check[board[tmp]] == 0) {
					queue.offer(board[tmp]);
					check[board[tmp]] = check[now] + 1;
				}

				if (board[tmp] == 100) {
					break;
				}
			}
		}
		return check[100];
	}
}