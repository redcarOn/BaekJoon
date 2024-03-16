
//No.11286(절댓값 힙) - 우선순위큐(2개사용)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main23 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pqp = new PriorityQueue<>();
		PriorityQueue<Integer> pqm = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				int num = 0;

				if (pqp.isEmpty() && pqm.isEmpty()) {
					num = 0;
				} else if (pqp.isEmpty() && !pqm.isEmpty()) {
					num = pqm.poll();
				} else if (!pqp.isEmpty() && pqm.isEmpty()) {
					num = pqp.poll();
				} else {
					if (pqp.peek() >= Math.abs(pqm.peek())) {
						num = pqm.poll();
					} else {
						num = pqp.poll();
					}
				}
				sb.append(num).append('\n');
			} else if (x > 0) {
				pqp.offer(x);
			} else {
				pqm.offer(x);
			}
		}

		System.out.println(sb);
	}
}