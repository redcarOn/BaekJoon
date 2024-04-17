
// No.1013(Contact) - 60
// 문자열  + 정규표현식
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class G5_1013 {
	private static final Pattern P = Pattern.compile("(100+1+|01)+");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			if (P.matcher(br.readLine()).matches()) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}

		System.out.println(sb.toString());
	}
}