
//No.1946(신입 사원) - GreedyMethod(class생성)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Grade implements Comparable<Grade> {
	int a;
	int b;

	Grade(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Grade o) {
		if (this.a > o.a) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class Main19_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Grade> list = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list.add(new Grade(a, b));
			}

			Collections.sort(list);

			int cnt = 1;
			int min = list.get(0).b;

			for (int j = 1; j < N; j++) {
				if (list.get(j).b < min) {
					cnt++;
					min = list.get(j).b;
				}
			}
			sb.append(cnt).append('\n');
		}

		System.out.println(sb);
	}
}