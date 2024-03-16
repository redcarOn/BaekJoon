
//No. 17413
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main32_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "<> ", true);

		boolean isOpen = false;

		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (s.equals("<")) {
				isOpen = true;
				sb.append(s);
			} else if (s.equals(">")) {
				isOpen = false;
				sb.append(s);
			} else if (isOpen) {
				sb.append(s);
			} else {
				StringBuilder sb2 = new StringBuilder(s);
				sb.append(sb2.reverse().toString());
			}
		}
		System.out.println(sb);
	}
}