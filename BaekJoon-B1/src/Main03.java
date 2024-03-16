
//No.1157
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c - 'a' >= 0) {
				arr[c - 'a']++;
			} else {
				arr[c - 'A']++;
			}
		}

		int max = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				count = i;
			}
		}

		int lap = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				lap++;
			}
		}

		if (lap > 1) {
			System.out.println("?");
		} else {
			System.out.println((char) ('A' + count));
		}

	}
}