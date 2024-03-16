
//No.13414
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main54 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LinkedHashSet<String> set = new LinkedHashSet<>();

		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		for (int i = 0; i < L; i++) {
			String num = br.readLine();

			if (set.contains(num)) {
				set.remove(num);
			}
			set.add(num);
		}

		int count = 0;
		for (String val : set) {
			sb.append(val).append('\n');
			count++;

			if (count == K) {
				break;
			}
		}
		System.out.println(sb);
	}
}