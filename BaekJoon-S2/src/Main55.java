
//NO.2607(비슷한 단어)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main55 {
	public static String first;
	public static int num;
	public static int[] arr;
	public static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		first = br.readLine();
		arr = new int[26];

		for (int i = 0; i < first.length(); i++) {
			arr[first.charAt(i) - 'A']++;
		}

		int cnt = 0;

		for (int i = 0; i < N - 1; i++) {
			check = arr.clone();
			String tmp = br.readLine();

			if (Math.abs(first.length() - tmp.length()) > 1) {
				continue;
			}

			int count = 0;

			for (int j = 0; j < tmp.length(); j++) {
				int idx = tmp.charAt(j) - 'A';
				if (check[idx] > 0) {
					count++;
					check[idx]--;
				}
			}

			if (first.length() - 1 == tmp.length()) {
				if (count == tmp.length()) {
					cnt++;
				}
			}

			else if (first.length() == tmp.length()) {
				if (count == first.length()) {
					cnt++;
				} else if (count == first.length() - 1) {
					cnt++;
				}
			}

			else if (first.length() + 1 == tmp.length()) {
				if (count == first.length()) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}