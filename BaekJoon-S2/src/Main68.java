
//No.1254(팰린드롬 만들기)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main68 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int ans = s.length();

		for (int i = 0; i < s.length(); i++) {
			if (check(s.substring(i))) {
				break;
			}
			ans++;
		}

		System.out.println(ans);
	}

	public static boolean check(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
}