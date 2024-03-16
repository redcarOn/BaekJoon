
//No.1002
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			int len = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			int r = (int) Math.pow(r1 + r2, 2);

			if (len > r) {
				sb.append(0);
			} else if (len == r) {
				sb.append(1);
			} else {
				if (len == 0 && r1 == r2) {
					sb.append(-1);
				} else if (len < Math.pow(r2 - r1, 2)) {
					sb.append(0);
				} else if (len == Math.pow(r2 - r1, 2)) {
					sb.append(1);
				} else if (len > Math.pow(r2 - r1, 2)) {
					sb.append(2);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}