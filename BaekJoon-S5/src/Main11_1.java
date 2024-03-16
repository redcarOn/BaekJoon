
//No.11723
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int S = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cal = st.nextToken();
			if (cal.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				S |= 1 << (x - 1);
			} else if (cal.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				S &= ~(1 << (x - 1));
			} else if (cal.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				int bit = (1 << (x - 1));
				if ((S & bit) == bit) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (cal.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				S ^= 1 << (x - 1);
			} else if (cal.equals("all")) {
				for (int j = 0; j < 20; j++) {
					S |= 1 << j;
				}
			} else if (cal.equals("empty")) {
				S = 0;
			}
		}
		System.out.print(sb);
	}
}