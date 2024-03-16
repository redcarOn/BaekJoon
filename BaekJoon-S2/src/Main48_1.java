
//No,11060 - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main48_1 {
	public static class position {
		int idx, cnt;

		public position(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(search(arr, N));
	}

	public static int search(int[] arr, int N) {
		Queue<position> queue = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];

		visit[1] = true;
		queue.add(new position(1, 0));

		while (!queue.isEmpty()) {
			position tmp = queue.poll();

			if (tmp.idx == N) {
				return tmp.cnt;
			}

			for (int i = 1; i <= arr[tmp.idx]; i++) {
				int tmpidx = tmp.idx + i;

				if (tmpidx <= N && !visit[tmpidx]) {
					visit[tmpidx] = true;
					queue.add(new position(tmpidx, tmp.cnt + 1));
				}
			}
		}
		return -1;
	}
}