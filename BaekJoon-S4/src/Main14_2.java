
//No.1620
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main14_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> hMap = new HashMap<>();
		String[] arr = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			hMap.put(name, i);
			arr[i] = name;
		}

		while (M > 0) {
			String s = br.readLine();

			if ('0' < s.charAt(0) && s.charAt(0) <= '9') {
				sb.append(arr[Integer.parseInt(s)]);
			} else {
				sb.append(hMap.get(s));
			}
			sb.append("\n");
			M--;
		}
		System.out.println(sb);
	}
}