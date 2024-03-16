
//No.11286(절댓값 힙) - 우선순위큐(Comparator)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main23_1 {
	public static class Mem implements Comparable<Mem> {
		int abs;
		int num;

		public Mem(int abs, int num) {
			this.abs = abs;
			this.num = num;
		}

		@Override
		public int compareTo(Mem o) {
			if (this.abs == o.abs) {
				return this.num - o.num;
			}
			return this.abs - o.abs;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Mem> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					sb.append(pq.poll().num).append('\n');
				}
			} else {
				pq.offer(new Mem(Math.abs(x), x));
			}
		}

		System.out.println(sb);
	}
}