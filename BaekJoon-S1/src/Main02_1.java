
//No.1931(회의실 배정) - Greedy Method(종료시간순 정렬) + 우선순위 큐
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main02_1 {
	public static class Time implements Comparable<Time> {
		int start;
		int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {

			if (this.end == o.end) {
				return this.start - o.start;
			}

			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		PriorityQueue<Time> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int t1, t2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());
			pq.offer(new Time(t1, t2));
		}

		int cnt = 1;
		int endTime = pq.poll().end;

		while (!pq.isEmpty()) {
			Time t = pq.poll();

			if (endTime <= t.start) {
				endTime = t.end;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}