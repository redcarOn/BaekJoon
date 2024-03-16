
//No.13335(트럭) - 큐 + 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main55_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Queue<Integer> truck = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}

		Queue<Integer> bridge = new ArrayDeque<>();
		for (int i = 0; i < W; i++) {
			bridge.offer(0);
		}
		int sum = 0;
		int time = 0;

		while (!bridge.isEmpty()) {
			sum -= bridge.poll();

			if (!truck.isEmpty()) {
				if (sum + truck.peek() <= L) {
					int tmp = truck.poll();
					sum += tmp;
					bridge.offer(tmp);
				} else {
					bridge.offer(0);
				}
			}
			time++;
		}

		System.out.println(time);
	}
}