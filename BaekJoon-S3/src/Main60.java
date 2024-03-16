
//No.3613★
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main60 {
	public static char[] str;
	public static StringBuilder sb;
	public static boolean language = true; // true:자바, false: C++
	public static boolean allLower = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		str = br.readLine().toCharArray();
		if (!(isJava(str) && isCpp(str) && check(str))) {
			System.out.println("Error!");
			return;
		}

		if (allLower) {
			for (char val : str) {
				sb.append(val);
			}
		} else {
			if (language) {
				toCpp(str);
			} else {
				toJava(str);
			}
		}
		System.out.println(sb);
	}

	public static boolean isJava(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] >= 'A' && arr[i] <= 'Z') {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isCpp(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] == '_') {
					return false;
				}
				continue;
			}

			if (i == arr.length - 1) {
				if (arr[i] == '_') {
					return false;
				}
				continue;
			}

			if (arr[i] == '_' && arr[i - 1] == '_') {
				return false;
			}
		}
		return true;
	}

	public static boolean check(char[] arr) {
		boolean isUpperCase = false;
		boolean isUnderBar = false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				isUpperCase = true;
				continue;
			}
			if (arr[i] == '_') {
				isUnderBar = true;
				continue;
			}
		}

		if (isUpperCase == false && isUnderBar == false) {
			allLower = true;
		} else {
			allLower = false;
		}

		if (isUpperCase ^ isUnderBar || allLower) {
			language = (isUnderBar) ? false : true;
			return true;
		} else {
			return false;
		}
	}

	public static void toCpp(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				sb.append('_');
				sb.append(String.valueOf(arr[i]).toLowerCase());
				continue;
			}
			sb.append(arr[i]);
		}
	}

	public static void toJava(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '_') {
				sb.append(String.valueOf(arr[i + 1]).toUpperCase());
				i++;
				continue;
			}
			sb.append(arr[i]);
		}
	}
}