
//No.11000(강의실 배정) - 우선순위큐 + 정렬(시작시간순)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main25 {
	public static class Node implements Comparable<Node> {
		int start;
		int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Node[] time = new Node[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			time[i] = new Node(s, e);
		}

		Arrays.sort(time);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(time[0].end);

		for (int i = 1; i < N; i++) {
			if (time[i].start >= pq.peek()) {
				pq.poll();
			}
			pq.offer(time[i].end);
		}

		System.out.println(pq.size());
	}
}