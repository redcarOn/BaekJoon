
//No.18258
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {

			case "push":
				int X = Integer.parseInt(st.nextToken());
				queue.offer(X);
				break;

			case "pop":
				if (queue.size() == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
				break;

			case "size":
				sb.append(queue.size()).append("\n");
				break;

			case "empty":
				if (queue.size() == 0) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;

			case "front":
				if (queue.size() == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peek()).append("\n");
				}
				break;

			case "back":
				if (queue.size() == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(((LinkedList<Integer>) queue).peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}