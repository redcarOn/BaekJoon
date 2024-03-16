
//No.1244
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			if (st.nextToken().equals("1")) {
				arr[i] = true;
			}
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (sex == 1) {
				for (int j = 1; j <= (N / num); j++) {
					arr[num * j] = !arr[num * j];
				}
			} else {
				int front = num - 1;
				int back = num + 1;
				while (front >= 1 && back <= N) {
					if (arr[front] != arr[back]) {
						break;
					}
					front--;
					back++;
				}
				for (int k = (front + 1); k <= (back - 1); k++) {
					arr[k] = !arr[k];
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (arr[i]) {
				sb.append(1 + " ");
			} else {
				sb.append(0 + " ");
			}

			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}