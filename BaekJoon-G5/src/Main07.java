
//No.1011(Fly me to the Alpha Centauri) - 수학★★★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = y - x;
			int max = (int) Math.sqrt(dist);
			int ans = 0;
			if (max == Math.sqrt(dist)) {
				ans = max * 2 - 1;
			} else if (dist <= max * max + max) {
				ans = max * 2;
			} else {
				ans = max * 2 + 1;
			}
			sb.append(ans).append('\n');
		}

		System.out.println(sb);
	}
}