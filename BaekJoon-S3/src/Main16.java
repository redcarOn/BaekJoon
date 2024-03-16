
//No.1966
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			List<Integer> tmp = new ArrayList<>();
			Queue<Integer> queue = new LinkedList<>();
			Queue<Integer> pri = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				tmp.add(num);
				queue.offer(num);
				pri.offer(j);
			}

			int count = 0;

			while (!queue.isEmpty()) {
				int max = 0;

				for (int k = 0; k < tmp.size(); k++) {
					if (max < tmp.get(k)) {
						max = tmp.get(k);
					}
				}

				while (true) {
					if (tmp.get(0) == max) {
						break;
					} else {
						tmp.add(tmp.remove(0));
						queue.offer(queue.poll());
						pri.offer(pri.poll());
					}
				}
				tmp.remove(0);
				queue.poll();
				count++;
				if (pri.peek() == M) {
					break;
				} else {
					pri.poll();
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}