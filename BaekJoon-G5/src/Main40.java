
//No.17609(회문) - 투 포인터 + 문자열 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main40 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String s = br.readLine();

			sb.append(checkPalindrome(s)).append('\n');
		}

		System.out.println(sb);
	}

	public static int checkPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				if (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) {
					return 1;
				} else {
					return 2;
				}
			}
			left++;
			right--;
		}

		return 0;
	}

	public static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}