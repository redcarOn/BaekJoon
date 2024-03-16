
//No.1021
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main25 {
	public static Deque<Integer> deque;
	public static List<Integer> arr;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		deque = new ArrayDeque<>();
		arr = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			deque.offer(i);
			arr.add(i);
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			int loc = 0;

			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j) == idx) {
					loc = j;
					break;
				}
			}
			rotate(idx, loc);
		}
		System.out.println(count);
	}

	public static void rotate(int idx, int loc) {
		if (deque.peekFirst() == idx) {
			deque.poll();
			arr.remove(0);
			return;
		}
		if (loc > arr.size()) {
			loc = 0;
		}

		if (loc <= arr.size() / 2) {
			deque.offerLast(deque.pollFirst());
			arr.add(arr.remove(0));
			count++;
			rotate(idx, loc - 1);
		} else {
			deque.offerFirst(deque.pollLast());
			arr.add(0, arr.remove(arr.size() - 1));
			count++;
			rotate(idx, loc + 1);
		}
	}
}