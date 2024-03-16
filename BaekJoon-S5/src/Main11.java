
//No.11723
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Set<Integer> hSet = new HashSet<Integer>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cal = st.nextToken();
			if (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				switch (cal) {
				case "add":
					hSet.add(x);
					break;
				case "remove":
					hSet.remove(x);
					break;
				case "check":
					if (hSet.contains(x)) {
						sb.append(1 + "\n");
					} else {
						sb.append(0 + "\n");
					}
					break;
				case "toggle":
					if (hSet.contains(x)) {
						hSet.remove(x);
					} else {
						hSet.add(x);
					}
					break;
				}
			} else {
				switch (cal) {
				case "all":
					hSet.clear();
					for (int j = 1; j < 21; j++) {
						hSet.add(j);
					}
					break;
				case "empty":
					hSet.clear();
					break;
				case "default":
					break;
				}
			}
		}
		System.out.print(sb);
	}
}