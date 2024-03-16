
//No.9375
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main27 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> hMap = new HashMap<>();

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String key = st.nextToken();
				hMap.put(key, hMap.getOrDefault(key, 0) + 1);
			}
			int count = 1;
			for (int value : hMap.values()) {
				count *= (value + 1);
			}
			sb.append(count - 1).append('\n');
		}
		System.out.println(sb);
	}
}