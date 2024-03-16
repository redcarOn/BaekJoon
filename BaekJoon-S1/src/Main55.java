
//No.13335(트럭) - 큐 + 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main55 {
	public static int N, W, L;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(find());
	}

	public static int find() {
		Queue<Integer> queue = new ArrayDeque<>();
		int sum = 0;
		int time = 0;

		for (int i = 0; i < W; i++) {
			queue.offer(0);
		}

		int idx = 0;
		while (idx < N) {
			time++;

			sum -= queue.poll();
			if (sum + arr[idx] <= L) {
				queue.offer(arr[idx]);
				sum += arr[idx];
				idx++;
			} else {
				queue.offer(0);
			}
		}

		time += queue.size();

		return time;
	}
}