
//No.1316
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (check(s)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean check(String s) {
		boolean[] arr = new boolean[26];
		char temp;
		for (int i = 0; i < s.length(); i++) {
			temp = s.charAt(i);
			if (i > 0 && arr[temp - 'a'] && temp != s.charAt(i - 1)) {
				return false;
			} else {
				arr[temp - 'a'] = true;
			}
		}
		return true;
	}
}