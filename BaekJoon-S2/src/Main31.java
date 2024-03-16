
//No.16953★★ - BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main31 {
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());

		count = 0;

		System.out.println(BFS(A, B));
	}

	public static int BFS(long a, long b) {
		Queue<Long> queue = new LinkedList<>();
		queue.offer(a);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				long tmp = queue.poll();
				if (tmp == b) {
					return count + 1;
				}

				if (tmp * 2 <= b) {
					queue.offer(tmp * 2);
				}

				if (tmp * 10 + 1 <= b) {
					queue.offer(tmp * 10 + 1);
				}
			}
			count++;
		}
		return -1;
	}
}