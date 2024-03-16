
//No.1213
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main36 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'A']++;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				count++;
			}
		}

		int idx = -1;

		if (count > 1) {
			sb.append("I'm Sorry Hansoo");
		} else {
			for (int i = 0; i < arr.length; i++) {
				int tmp = arr[i];

				if (arr[i] % 2 == 1) {
					idx = i;
					if (arr[i] > 2) {
						while (arr[i] > (tmp + 1) / 2) {
							sb.append((char) (i + 'A'));
							arr[i]--;
						}
					}
				} else {
					while (arr[i] > tmp / 2) {
						sb.append((char) (i + 'A'));
						arr[i]--;
					}
				}
			}

			if (idx >= 0) {
				sb.append((char) (idx + 'A'));
				arr[idx]--;
			}

			for (int i = arr.length - 1; i >= 0; i--) {
				while (arr[i] > 0) {
					sb.append((char) (i + 'A'));
					arr[i]--;
				}
			}
		}
		System.out.println(sb);
	}
}

/*answer += sb.reverse().toString();*/